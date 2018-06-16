package com.springcloud.product.service;

import com.springcloud.product.ProductApplicationTests;
import com.springcloud.product.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: wangcheng
 * @Date: Created in 12:50 2018/6/12
 */
@Component
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(categoryList.size() > 0);
    }
}