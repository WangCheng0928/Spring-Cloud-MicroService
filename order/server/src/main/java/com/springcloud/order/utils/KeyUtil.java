package com.springcloud.order.utils;

import java.util.Random;

/**
 * @Author: wangcheng
 * @Date: Created in 10:35 2018/6/14
 */
public class KeyUtil {

    /*
     *生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        //为了使每一个随机数的长度都相同
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
