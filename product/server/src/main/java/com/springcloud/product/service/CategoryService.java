package com.springcloud.product.service;

import com.springcloud.product.pojo.ProductCategory;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 12:46 2018/6/12
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
