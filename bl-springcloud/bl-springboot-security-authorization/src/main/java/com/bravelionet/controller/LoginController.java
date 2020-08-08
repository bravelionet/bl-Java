package com.bravelionet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/login-view")
    public String login(){

        return "login";
    }

}
