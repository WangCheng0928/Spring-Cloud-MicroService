package com.springcloud.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author: wangcheng
 * @Date: Created in 10:42 2018/6/17
 */
@Data
public class ProductInfoOutput {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;
}
