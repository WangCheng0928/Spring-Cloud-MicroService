package com.springcloud.product.exception;

import com.springcloud.product.enums.ResultEnum;
import lombok.Data;

/**
 * @Author: wangcheng
 * @Date: Created in 14:43 2018/6/16
 */
@Data
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
