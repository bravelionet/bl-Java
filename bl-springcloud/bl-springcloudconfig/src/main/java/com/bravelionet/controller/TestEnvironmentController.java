package com.bravelionet.controller;

import com.bravelionet.service.TestEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
public class TestEnvironmentController {
    private Environment environment;
    @Autowired
    private TestEnvironmentService testEnvironmentService;

    public TestEnvironmentController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/locl/{env}")
    public Object getEnv(@PathVariable("env") String env) {
        System.out.println("env = " + env);
        String[] activeProfiles = environment.getActiveProfiles();
        String[] defaultProfiles = environment.getDefaultProfiles();
        Object propertySources = environment.getProperty("propertySources");
        Map<String, Object> envMap = new HashMap<>();
        envMap.put("activeProfiles", activeProfiles);
        envMap.put("defaultProfiles", defaultProfiles);
        envMap.put("propertySources", propertySources);
        System.out.println("environment = " + environment);
        testEnvironmentService.test();
        return 1;
    }
}
