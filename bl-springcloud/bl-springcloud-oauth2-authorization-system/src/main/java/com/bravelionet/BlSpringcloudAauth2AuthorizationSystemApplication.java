package com.bravelionet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Authror Lionet
 * @Date 2020-08-13 17:32
 * @Description 认证授权服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.bravelionet"})
public class BlSpringcloudAauth2AuthorizationSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlSpringcloudAauth2AuthorizationSystemApplication.class,args);
    }
}
