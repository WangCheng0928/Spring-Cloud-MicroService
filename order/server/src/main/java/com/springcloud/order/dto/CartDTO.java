package com.springcloud.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wangcheng
 * @Date: Created in 14:39 2018/6/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    //商品id
    private String productId;

    //商品数量
    private Integer productQuantity;

}
