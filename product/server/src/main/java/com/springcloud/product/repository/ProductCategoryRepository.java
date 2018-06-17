package com.springcloud.product.repository;

import com.springcloud.product.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 11:10 2018/6/12
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
