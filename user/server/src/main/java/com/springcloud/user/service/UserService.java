package com.springcloud.user.service;

import com.springcloud.user.pojo.UserInfo;

/**
 * @Author: wangcheng
 * @Date: Created in 13:22 2018/6/22
 */
public interface UserService {

    UserInfo findByOpenid(String openid);
}
