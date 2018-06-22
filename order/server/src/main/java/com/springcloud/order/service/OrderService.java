package com.springcloud.order.service;

import com.springcloud.order.dto.OrderDTO;

/**
 * @Author: wangcheng
 * @Date: Created in 10:10 2018/6/14
 */
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(String orderId);
}
