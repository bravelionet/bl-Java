package com.bravelionet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {"com.bravelionet"})
@EnableFeignClients(basePackages = {"com.bravelionet"})
public class BlSpringCloudOAuth2AuthrizationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlSpringCloudOAuth2AuthrizationServerApplication.class,args);
    }
}
