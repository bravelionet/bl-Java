package com.bravelionet;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages = {"com.bravelionet.client"})
@EnableDubbo
public class BlspringCloudZookeeperClinetApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlspringCloudZookeeperClinetApplication.class,args);
    }
}

