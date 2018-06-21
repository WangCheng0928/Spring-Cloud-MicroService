package com.springcloud.order.message;

import com.springcloud.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wangcheng
 * @Date: Created in 21:09 2018/6/20
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(Object message){
//        log.info("StreamReceiver: {}", message);
//    }

    /**
     * @Author: wangcheng
     * @param null
     * @Description 接收orderDTO对象 消息
     * @Date: 10:34 2018/6/21
     * @return
     */
    @StreamListener(value = StreamClient.INPUT)
    public void process(OrderDTO message){
        log.info("StreamReceiver: {}", message);
    }
}
