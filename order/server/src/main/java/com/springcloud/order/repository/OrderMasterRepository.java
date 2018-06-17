package com.springcloud.order.repository;

import com.springcloud.order.pojo.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: wangcheng
 * @Date: Created in 16:25 2018/6/12
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
