package com.bravelionet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Authror Lionet
 * @Date 2020-08-13 17:38
 * @Description 资源服务
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BlSpringcloudOauth2ResourceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlSpringcloudOauth2ResourceServerApplication.class, args);
    }
}
