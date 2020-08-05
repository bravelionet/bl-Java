package com.bravelionet.model;

import lombok.Data;

/**
 * @Authror Lionet
 * @Date 2020/8/5 14:56
 * @Description
 */

@Data
public class AuthenticationRequest {
    //认证请求参数，账号、密码。。
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
