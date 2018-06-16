package com.springcloud.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author: wangcheng
 * @Date: Created in 10:46 2018/6/14
 */
@Data
public class OrderForm {

    //买家姓名
    @javax.validation.constraints.NotEmpty(message = "姓名必填")
    private String name;

    //买家手机号
    @javax.validation.constraints.NotEmpty(message = "手机号必填")
    private String phone;

    //买家地址
    @javax.validation.constraints.NotEmpty(message = "地址必填")
    private String address;

    //买家微信openid
    @javax.validation.constraints.NotEmpty(message = "openid必填")
    private String openid;

    //购物车
    @javax.validation.constraints.NotEmpty(message = "购物车不能为空")
    private String items;


}
