package com.springcloud.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: wangcheng
 * @Date: Created in 14:43 2018/6/16
 */
@AllArgsConstructor
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存不足"),
    ;

    private Integer code;

    private String message;


}
