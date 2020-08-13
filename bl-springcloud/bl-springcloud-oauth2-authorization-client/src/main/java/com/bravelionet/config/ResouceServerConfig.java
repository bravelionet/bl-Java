package com.bravelionet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Authror Lionet
 * @Date 2020-08-12 16:54
 * @Description 资源服务测试配置类
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {
    // 标识客户端
    public static final String RESOURCE_ID = "res1";

    @Autowired
    TokenStore tokenStore;
    /**
     * @Author: Lionet
     * @Date 2020/8/12 17:02
     * @Description 资源服务配置管理
     * @Param:
     * @Return:
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID) // 配置 客户端 ID
              //  .tokenServices(this.tokenService())
                .tokenStore(tokenStore)
                .stateless(true); // 这些资源上允许基于令牌的身份验证的标志
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('all')")
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 配置不会 创建 session
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/12 17:07
     * @Description 资源服务令牌解析服务, 用于远程授权服务校验
     * @Param:
     * "aud" -> {ArrayList@10777}  size = 1
     * "user_name" -> "root"
     * "client_id" -> "bl_client"
     * "authorities" -> {ArrayList@10787}  size = 2
     * "active" -> {Boolean@10783} true
     * "scope" -> {ArrayList@10781}  size = 1
     * "exp" -> {Integer@10785} 1597295861
     * RemoteTokenServices : 请求 校验 响应值  active 不存在
     *  原因 :  依赖版本低 升级 2.3.1.RELEASE 即可
     * @Return:
     */
  /*  @Bean
    public ResourceServerTokenServices tokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        RemoteTokenServices service = new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:9092/oauth/check_token");
        service.setClientId("bl_client");
        service.setClientSecret("bl_secret");
        return service;
    }*/
}
