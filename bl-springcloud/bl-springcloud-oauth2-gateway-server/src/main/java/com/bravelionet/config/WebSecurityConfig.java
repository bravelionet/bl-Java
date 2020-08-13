package com.bravelionet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: Lionet
 * @Date 2020/8/13 22:36
 * @Description gateway 放行所有路径,无需认证
 * @Param:
 * @Return:
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and().csrf().disable();
    }
}
