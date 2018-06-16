package com.springcloud.product.VO;

import lombok.Data;

/**
 * @Author: wangcheng
 * @Date: Created in 12:52 2018/6/12
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
