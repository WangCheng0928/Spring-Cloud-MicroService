package com.springcloud.user.service.impl;

import com.springcloud.user.Repository.UserInfoRepository;
import com.springcloud.user.pojo.UserInfo;
import com.springcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangcheng
 * @Date: Created in 13:24 2018/6/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    //通过openid查询用户信息
    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
