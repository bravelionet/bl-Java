package com.bravelionet.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authror Lionet
 * @Date 2020-08-12 18:49
 * @Description 资源测试类
 */
@RestController
public class TestClient {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('root')")
    public String r1(){
        return "访问资源1";
    }
}
