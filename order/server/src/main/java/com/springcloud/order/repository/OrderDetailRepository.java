package com.springcloud.order.repository;

import com.springcloud.order.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 16:49 2018/6/12
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
