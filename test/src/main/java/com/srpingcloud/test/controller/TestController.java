package com.srpingcloud.test.controller;

import com.srpingcloud.test.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcheng
 * @Date: Created in 12:58 2018/6/15
 */
@RestController
public class TestController {

    @Autowired
    private TestClient testClient;

    @RequestMapping("/getMsg")
    public String getMsg(){
        String resp = testClient.test();
        return resp;
    }
}
