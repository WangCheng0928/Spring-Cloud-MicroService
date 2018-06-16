package com.springcloud.testserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TestserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestserverApplication.class, args);
    }
}
