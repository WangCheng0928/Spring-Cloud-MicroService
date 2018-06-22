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
    ORDER_NOT_EXIST(3, "订单不存在"),
    ORDER_STATUS_ERROR(4, "订单状态错误"),
    ORDER_DETAIL_NOT_EXIST(5, "订单详情不存在")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
