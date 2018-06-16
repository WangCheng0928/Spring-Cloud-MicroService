package com.springcloud.testclient.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcheng
 * @Date: Created in 17:01 2018/6/14
 */
@RestController
public class mytestController {

    @RequestMapping("/msg")
    public String testString(){
        return "this is my test";
    }
}
