package com.springcloud.order.exception;

import com.springcloud.order.enums.ResultEnum;

/**
 * @Author: wangcheng
 * @Date: Created in 11:16 2018/6/14
 */
public class OrderException extends RuntimeException {

    private Integer code;
    public OrderException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
