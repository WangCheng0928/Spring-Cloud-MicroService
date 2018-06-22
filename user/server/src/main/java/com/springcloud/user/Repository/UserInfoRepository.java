package com.springcloud.user.Repository;

import com.springcloud.user.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: wangcheng
 * @Date: Created in 12:50 2018/6/22
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByOpenid(String openid);
}
