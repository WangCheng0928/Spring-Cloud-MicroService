package com.springcloud.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: wangcheng
 * @Date: Created in 14:39 2018/6/22
 */
@Getter
@AllArgsConstructor
public enum  RoleEnum {
    BUYER(1, "买家"),
    SELLER(2, "卖家"),
    ;

    private Integer code;

    private String message;
}
