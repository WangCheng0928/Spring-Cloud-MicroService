package com.springcloud.product.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: wangcheng
 * @Date: Created in 10:42 2018/6/17
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;
}
