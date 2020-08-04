package com.bravelionet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigServer
@ComponentScan(basePackages="com.bravelionet")
@ComponentScan(basePackages= "com.bravelionet.dao")
@ComponentScan(basePackages= "com.bravelionet.mapper")
public class BlSpringcloudconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlSpringcloudconfigApplication.class, args);
	}

}
