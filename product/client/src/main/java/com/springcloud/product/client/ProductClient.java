package com.springcloud.product.client;

import com.springcloud.product.common.DecreaseStockInput;
import com.springcloud.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: wangcheng
 * @Date: Created in 10:28 2018/6/17
 */
@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);


    @Component
    static class ProductClientFallback implements ProductClient{
        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> cartDTOList) {

        }
    }
}
