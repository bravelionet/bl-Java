package com.bravelionet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lionet
 * @Date 2020/8/13 17:45
 * @Description 放行 URL,配置类,读取 yml 配置 (application.skip-authorization:*)
 * @Param:
 * @Return:
 */
@ConfigurationProperties(SkipAuthUrlsProperties.PREFIX)
@Component
public class SkipAuthUrlsProperties {
    /**
     * 配置项目 properties
     */
    public static final String PREFIX = "application.skip-authorization";

    private List<String> skipAuthUrls = new ArrayList<>();

    public static String getPREFIX() {
        return PREFIX;
    }

    public List<String> getSkipAuthUrls() {
        return skipAuthUrls;
    }

    public void setSkipAuthUrls(List<String> skipAuthUrls) {
        this.skipAuthUrls = skipAuthUrls;
    }
}
