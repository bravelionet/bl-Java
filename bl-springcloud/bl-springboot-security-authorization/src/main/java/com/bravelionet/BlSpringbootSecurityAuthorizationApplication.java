package com.bravelionet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.bravelionet"})
public class BlSpringbootSecurityAuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlSpringbootSecurityAuthorizationApplication.class);
    }
}
