package com.bravelionet.api;

import com.bravelionet.model.AuthenticationRequest;
import com.bravelionet.model.UserDto;

/**
 * @Authror Lionet
 * @Date 2020/8/5 14:56
 * @Description
 */

public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return 认证成功的用户信息
     */
    UserDto authentication(AuthenticationRequest authenticationRequest);
}
