package com.springcloud.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: wangcheng
 * @Date: Created in 17:47 2018/6/12
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {

    WAIT(0, "待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;

    private String message;
}
