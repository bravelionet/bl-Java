package com.bravelionet;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 不配置扫包,默认扫该类同级及子包下
@SpringBootApplication
// 使用 dubbo 使用该注解, 不使用则不配置
@EnableDubbo
public class BlSpringBootZipKinServiceDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlSpringBootZipKinServiceDubboApplication.class, args);
    }
}
