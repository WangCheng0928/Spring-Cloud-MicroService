package com.springcloud.order.message;

import com.springcloud.order.utils.JsonUtil;
import com.springcloud.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 14:52 2018/6/21
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message){
        //message => ProductInfoOutput
        List<ProductInfoOutput> productInfoOutputList = JsonUtil.string2Obj(message, new TypeReference<List<ProductInfoOutput>>() {});
        log.info("从队列【{}】接收到消息: {}","productInfo", productInfoOutputList);
        //存储到redis中
        for (ProductInfoOutput productInfoOutput : productInfoOutputList){
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput.getProductId()),
                    String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
