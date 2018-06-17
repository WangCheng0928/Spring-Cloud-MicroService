package com.springcloud.product.service;

import com.springcloud.product.common.DecreaseStockInput;
import com.springcloud.product.pojo.ProductInfo;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 11:44 2018/6/12
 */
public interface ProductService {

    //查询所有在架商品列表
    List<ProductInfo> findUpAll();

    //查询商品列表
    List<ProductInfo> findList(List<String> productIdList);

    //扣库存
    void decreaseStock(List<DecreaseStockInput> cartDTOList);
}
