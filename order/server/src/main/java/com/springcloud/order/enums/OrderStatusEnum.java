package com.springcloud.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: wangcheng
 * @Date: Created in 17:44 2018/6/12
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;

    private Integer code;

    private String message;


}
