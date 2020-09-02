package com.bravelionet.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authror Lionet
 * @Date 2020-08-12 18:49
 * @Description 资源测试类
 */
@RestController
@RequestMapping("/self")
public class TestClient {

    @GetMapping(value = "/r1")
    @PreAuthorize("hasAnyAuthority('manager')")
    public String r1() {
        return "访问资源1";
    }


    @RequestMapping(value = "/lionetTest",method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('manager')")
    public String lionetTest() {
        return "测试!";
    }

}
