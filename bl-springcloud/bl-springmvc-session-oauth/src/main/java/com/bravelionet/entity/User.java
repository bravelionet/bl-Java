package com.bravelionet.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * @Author: Lionet
 * @Date 2020/8/4 23:48
 * @Description 用户信息
 * @Param:
 * @Return:
 */
public class User implements Serializable {

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

    public User() {
    }

    public User(String id, String username, String password, String fullname, String mobile, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.mobile = mobile;
        this.authorities = authorities;
    }

    public static String getSessionUserKey() {
        return SESSION_USER_KEY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }






    @Override
    public String toString() {
        return "User{" +
                "authorities=" + authorities +
                ", fullname='" + fullname + '\'' +
                ", id='" + id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
