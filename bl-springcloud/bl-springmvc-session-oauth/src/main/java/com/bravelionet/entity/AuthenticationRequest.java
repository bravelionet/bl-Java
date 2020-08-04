package com.bravelionet.entity;

public class AuthenticationRequest {
    //认证请求参数，账号、密码。。
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
