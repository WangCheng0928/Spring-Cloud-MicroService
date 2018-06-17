package com.springcloud.product.repository;

import com.springcloud.product.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 10:56 2018/6/12
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
