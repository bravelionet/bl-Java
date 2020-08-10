package com.bravelionet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BlSpringCloudOauth2AuthorizationClient {
    public static void main(String[] args) {
        SpringApplication.run(BlSpringCloudOauth2AuthorizationClient.class);
    }
}
