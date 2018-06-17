package com.springcloud.order.service;

import com.springcloud.order.dto.OrderDTO;

/**
 * @Author: wangcheng
 * @Date: Created in 10:10 2018/6/14
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);
}
