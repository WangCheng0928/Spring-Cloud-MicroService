package com.springcloud.order.VO;

import lombok.Data;

/**
 * @Author: wangcheng
 * @Date: Created in 11:44 2018/6/14
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
