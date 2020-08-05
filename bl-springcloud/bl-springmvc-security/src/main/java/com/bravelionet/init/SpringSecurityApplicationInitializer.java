package com.bravelionet.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @Author: Lionet
 * @Date 2020/8/5 16:06
 * @Description 初始化 Sercurity 配置
 * @Param:
 * @Return:
 */
public class SpringSecurityApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {
    /**
     * @Author: Lionet
     * @Date 2020/8/5 16:07
     * @Description
     * Spring Security 初始化，这里有两种情况
     *        若环境没有使用 Spring或 Spring MVC，则需要将 WebSecurityConfig(Spring Security配置类) 传入超
     *              类(父类)，以确保获取配置，并创建spring context。
     *        相反，若当前环境已经使用 spring，应该在现有的springContext中注册Spring Security(上一步已经做将
     *              WebSecurityConfig加载至 rootcontext)，此方法可以什么都不做
     * @Param:
     * @Return:
     */
    public SpringSecurityApplicationInitializer() {
        //super(WebSecurityConfig.class);
    }
}
