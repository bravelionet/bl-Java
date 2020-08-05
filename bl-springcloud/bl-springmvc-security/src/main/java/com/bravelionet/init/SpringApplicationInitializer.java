package com.bravelionet.init;

import com.bravelionet.config.ApplicationConfig;
import com.bravelionet.config.WebConfig;
import com.bravelionet.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @Authror Lionet
 * @Date 2020/8/5 16:05
 * @Description tomcat 启动初始化项目
 */

public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @Author: Lionet
     * @Date 2020/8/5 16:06
     * @Description spring容器，相当于加载 applicationContext.xml
     * @Param:
     * @Return:
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/5 16:06
     * @Description servletContext，相当于加载springmvc.xml
     * @Param:
     * @Return:
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/5 16:06
     * @Description url-mapping
     * @Param:
     * @Return:
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
