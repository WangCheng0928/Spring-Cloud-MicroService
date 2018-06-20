package com.springcloud.order.controller;

import com.springcloud.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcheng
 * @Date: Created in 14:38 2018/6/20
 */
@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print(){
        return "name: " + girlConfig.getName()+ ", " + "age: " + girlConfig.getAge();
    }
}
