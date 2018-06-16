package com.springcloud.order.controller;

import com.springcloud.order.client.ProductClient;
import com.springcloud.order.dto.CartDTO;
import com.springcloud.order.pojo.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 14:56 2018/6/14
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> productInfoList =  productClient.listForOrder(Arrays.asList("157875227953464068"));
        log.info("response={}",productInfoList);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022", 3)));
        return "ok";
    }
}
