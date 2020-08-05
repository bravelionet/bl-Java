package com.bravelionet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @Authror Lionet
 * @Date 2020/8/5 14:56
 * @Description
 */

@Data
@AllArgsConstructor
public class UserDto {
    public static final String SESSION_USER_KEY = "_user";
    //用户身份信息
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
    /**
     * 用户权限
     */
    private Set<String> authorities;
}
