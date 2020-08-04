package com.bravelionet.api;

import com.bravelionet.entity.AuthenticationRequest;
import com.bravelionet.entity.User;

/**
 * @Author: Lionet
 * @Date 2020/8/5 0:03
 * @Description 登录认证及资源权限控制
 * @Param:
 * @Return:
 */
public interface AuthenticationService {


    /**
     * @Author: Lionet
     * @Date 2020/8/5 0:04
     * @Description  用户认证
     * @Param: authenticationRequest 用户认证请求，账号和密码
     * @Return: 认证成功的用户信息
     */
    User authentication(AuthenticationRequest authenticationRequest);
}
