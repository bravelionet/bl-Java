package com.bravelionet;

 import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubbo
public class BlspringCloudZookeeperServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlspringCloudZookeeperServerApplication.class,args);
    }
}
