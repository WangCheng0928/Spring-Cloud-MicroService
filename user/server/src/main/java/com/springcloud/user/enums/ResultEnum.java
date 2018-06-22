package com.springcloud.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: wangcheng
 * @Date: Created in 14:35 2018/6/22
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    LOGIN_FAIL(1, "登录失败"),
    ROLE_ERROR(2, "角色无权限")
    ;

    private Integer code;

    private String message;


}
