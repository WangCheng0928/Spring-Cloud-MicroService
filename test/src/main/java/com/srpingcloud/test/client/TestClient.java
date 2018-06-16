package com.srpingcloud.test.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: wangcheng
 * @Date: Created in 12:57 2018/6/15
 */
@FeignClient(value = "testclient")
public interface TestClient {

    @GetMapping("/msg")
    String test();
}
