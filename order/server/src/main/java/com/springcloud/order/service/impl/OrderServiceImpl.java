package com.springcloud.order.service.impl;

import com.springcloud.order.dto.CartDTO;
import com.springcloud.order.dto.OrderDTO;
import com.springcloud.order.enums.OrderStatusEnum;
import com.springcloud.order.enums.PayStatusEnum;
import com.springcloud.order.pojo.OrderDetail;
import com.springcloud.order.pojo.OrderMaster;
import com.springcloud.order.pojo.ProductInfo;
import com.springcloud.order.repository.OrderDetailRepository;
import com.springcloud.order.repository.OrderMasterRepository;
import com.springcloud.order.service.OrderService;
import com.springcloud.order.utils.KeyUtil;
import com.springcloud.product.client.ProductClient;
import com.springcloud.product.common.DecreaseStockInput;
import com.springcloud.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: wangcheng
 * @Date: Created in 10:27 2018/6/14
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.getUniqueKey();
        //查询过商品信息(调用商品服务)
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                                .map(OrderDetail::getProductId)
                                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(productIdList);
        //计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()){
            for (ProductInfoOutput productInfoOutput : productInfoOutputList){
                if (productInfoOutput.getProductId().equals(orderDetail.getProductId())){
                    orderAmount = productInfoOutput.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.getUniqueKey());
                    //订单详情入库
//                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        //扣库存
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
