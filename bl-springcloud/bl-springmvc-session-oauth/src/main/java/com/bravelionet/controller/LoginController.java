package com.bravelionet.controller;

import com.bravelionet.api.AuthenticationService;
import com.bravelionet.entity.AuthenticationRequest;
import com.bravelionet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author: Lionet
 * @Date 2020/8/5 0:00
 * @Description 登录 控制器
 * @Param:
 * @Return:
 */
@RestController
public class LoginController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest authenticationRequest, HttpSession session){
        User userDto = authenticationService.authentication(authenticationRequest);
        //存入session
        session.setAttribute(User.SESSION_USER_KEY,userDto);
        return userDto.getUsername() +"登录成功";
    }

    @GetMapping(value = "/logout",produces = {"text/plain;charset=UTF-8"})
    public String logout(HttpSession session){
        // 请求 session
        session.invalidate();
        return "退出成功";
    }

    @GetMapping(value = "/root/query",produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session){
        String fullname = null;
        Object object = session.getAttribute(User.SESSION_USER_KEY);
        if(object == null){
            fullname = "匿名";
        }else{
            User userDto = (User) object;
            fullname = userDto.getFullname();
        }
        return fullname+"访问资源r1";
    }
    @GetMapping(value = "/root/update",produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session){
        String fullname = null;
        Object userObj = session.getAttribute(User.SESSION_USER_KEY);
        if(userObj != null){
            fullname = ((User)userObj).getFullname();
        }else{
            fullname = "匿名";
        }
        return fullname + " 访问资源2";
    }
}
