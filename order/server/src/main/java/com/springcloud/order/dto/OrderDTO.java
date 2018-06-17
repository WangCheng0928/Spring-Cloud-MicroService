package com.springcloud.order.dto;

import com.springcloud.order.pojo.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 10:23 2018/6/14
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    //订单状态, 默认为0新下单
    private Integer orderStatus;

    //支付状态,默认为0未支付
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
