package com.bravelionet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Authror Lionet
 * @Date 2020-08-13 17:46
 * @Description 网关服务, 各服务过滤拦截
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BlSpringCloudOauth2GatewayServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlSpringCloudOauth2GatewayServerApplication.class, args);
    }
}
