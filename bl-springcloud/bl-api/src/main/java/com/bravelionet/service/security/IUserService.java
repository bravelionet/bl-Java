package com.bravelionet.service.security;


import com.bravelionet.domain.security.User;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:20
 * @Description  用户 服务类
 */

public interface IUserService  {

    public User queryByName(String name);
}
