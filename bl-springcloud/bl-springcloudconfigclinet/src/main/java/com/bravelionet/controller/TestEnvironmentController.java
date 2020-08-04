package com.bravelionet.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Lionet
 * @Date 2020/7/17 22:41
 * @Description
 *  Environment : 整个项目的配置
 *
 * @Param:
 * @Return:
 */
@RestController
@RequestMapping("/env")
@RefreshScope
public class TestEnvironmentController {

    @Value("${test_config}")
    private String aa;

    @GetMapping("/locl/{env}")
    public Object getEnv(@PathVariable("env") String env) {

        System.out.println(" aa= " + aa);
        return aa;
    }
}
