package com.springcloud.order.controller;

import com.springcloud.order.dto.OrderDTO;
import com.springcloud.order.message.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: wangcheng
 * @Date: Created in 21:13 2018/6/20
 */
@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void process(){
//        String message = "now " + new Date();
//        log.info("现在时间: {}", new Date());
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    /**
     * @Author: wangcheng
     * @param null
     * @Description 发送orderDTO对象消息
     * @Date: 10:34 2018/6/21
     * @return
     */
    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
