package com.springcloud.order.enums;

import lombok.Getter;

/**
 * @Author: wangcheng
 * @Date: Created in 11:19 2018/6/14
 */
@Getter
public enum  ResultEnum {

    PARAMS_ERROR(1, "参数错误"),
    CART_EMPTY(2,"购物车为空"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
