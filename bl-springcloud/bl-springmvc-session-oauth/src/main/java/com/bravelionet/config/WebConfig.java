package com.bravelionet.config;

import com.bravelionet.interceptor.SimpleAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author: Lionet
 * @Date 2020/8/4 23:34
 * @Description 配置 web, 就相当于springmvc.xml文件
 * WebMvcConfigurer配置类其实是Spring内部的一种配置方式，
 * 采用JavaBean的形式来代替传统的xml配置文件形式进行针对框架个性化定制，
 * 可以自定义一些Handler，Interceptor，ViewResolver，MessageConverter。
 * 基于java-based方式的spring mvc配置，需要创建一个配置类并实现WebMvcConfigurer 接口；
 * @Param:
 * @Return:
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bravelionet"
        , includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;
    /**
     * @Author: Lionet
     * @Date 2020/8/4 23:38
     * @Description 配置视图解析器
     * @Param:
     * @Return:
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");// .html
        return viewResolver;
    }



    /**
     * @Author: Lionet
     * @Date 2020/8/4 23:41
     * @Description 添加拦截器
     * @Param:
     * @Return:
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleAuthenticationInterceptor).addPathPatterns("/r/**");
    }

}
