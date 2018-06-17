package com.springcloud.product.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcheng
 * @Date: Created in 14:54 2018/6/14
 */
@RestController
public class ServerController {

    @RequestMapping("/msg")
    public String msg(){
        return "this is product msg";
    }
}
