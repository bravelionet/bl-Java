package com.bravelionet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authror Lionet
 * @Date 2020/8/5 15:56
 * @Description
 */
@RestController
public class AuthController {



    @GetMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess(){
        return "登录成功";
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/5 16:39
     * @Description 根据 security受理权限, root 用户访问数据
     * @Param:
     * @Return:
     */
    @GetMapping(value = "/root/update",produces = {"text/plain;charset=UTF-8"})
    public String root(){
        return " 访问资源 root";
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/5 16:40
     * @Description  根据 security受理权限, root/admin 用户访问数据
     * @Param:
     * @Return:
     */
    @GetMapping(value = "/admin/query",produces = {"text/plain;charset=UTF-8"})
    public String admin(){
        return " 访问资源 admin";
    }
}
