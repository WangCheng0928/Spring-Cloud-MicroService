package com.springcloud.user.controller;

import com.springcloud.user.constant.CookieConstant;
import com.springcloud.user.constant.RedisConstant;
import com.springcloud.user.enums.ResultEnum;
import com.springcloud.user.enums.RoleEnum;
import com.springcloud.user.pojo.UserInfo;
import com.springcloud.user.service.UserService;
import com.springcloud.user.utils.CookieUtil;
import com.springcloud.user.utils.ResultVOUtil;
import com.springcloud.user.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wangcheng
 * @Date: Created in 14:06 2018/6/22
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //买家登录
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response){

        //1、openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2、判断角色
        if (RoleEnum.BUYER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3、cookie里设置openid
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.expire);
        return ResultVOUtil.success();
    }

    //卖家登录
    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletResponse response, HttpServletRequest request){
        //判断是否已登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
            return ResultVOUtil.success();
        }

        //1、openid和数据库里的数据是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2、判断角色
        if (RoleEnum.SELLER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3、redis设置key=UUID, value=xyz
        String token = UUID.randomUUID().toString();
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token), openid, expire, TimeUnit.SECONDS);
        //4、cookie里设置openid
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.expire);
        return ResultVOUtil.success();
    }

}
