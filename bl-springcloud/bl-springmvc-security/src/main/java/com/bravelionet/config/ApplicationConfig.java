package com.bravelionet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Authror Lionet
 * @Date 2020/8/5 15:57
 * @Description 相当于applicationContext.xml
 */

@Configuration
@ComponentScan(basePackages = "com.bravelionet"
            ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Controller.class)})
public class ApplicationConfig {
    //在此配置除了Controller的其它bean，比如：数据库链接池、事务管理器、业务bean等。
}
