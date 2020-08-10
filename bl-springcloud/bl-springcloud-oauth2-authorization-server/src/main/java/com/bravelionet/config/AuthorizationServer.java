package com.bravelionet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Author: Lionet
 * @Date 2020/8/10 13:18
 * @Description
 * 1. 配置客户端详情信息
 * 2. 配置令牌服务
 * 3. 配置令牌暴露端点
 * 4. 配置安全策略
 * @Param:
 * @Return:
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    /*
    // 配置安全策略
    // 那些人客户申请令牌
     public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    }

     // ：用来配置客户端详情服务（ClientDetailsService），客户端详情信息在
            这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    }

     //用来配置令牌（token）的访问端点和令牌服务(token services)
     // 申请令牌的 URL(端点)
     // 令牌怎么发放(令牌服务)
     // TokenStore 令牌存储方案
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    }
    * */


    @Autowired
    private ClientDetailsService clientDetailsService; // 客户端配置
    @Autowired
    private TokenStore tokenStore; // 令牌储存策略

    /**
     * @Author: Lionet
     * @Date 2020/8/10 11:51
     * @Description 配置客户端详情信息
     *
     * 1. 谁来申请令牌
     * 2. 客户端密钥
     * 3. 可以访问的资源列表
     * 4. 授权类型
     * 5. ......
     *
     * @Param:
     * @Return:
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        clients.inMemory()//  使用in‐memory存储(内存方式)
                .withClient("c1")//  允许谁来申请令牌, 客户端 Id
                .secret(new BCryptPasswordEncoder().encode("secret")) // 客户端密钥
                .resourceIds("res1") // 客户端可以访问的资源列表(资源服务的Id)
                .authorizedGrantTypes("authorization_code",
                        "password", "client_credentials",
                        "implicit", "refresh_token")//  该client允许的授权类型 authorization_code,password,refresh_token,implicit,client_credentials
                .scopes("all")//  允许的授权范围(客户端的权限)
                .autoApprove(false)// false 在申请授权码模式,就会跳转到授权页面
                .redirectUris("http://www.baidu.com");//加上验证回调地址
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/10 12:09
     * @Description 用来配置令牌（token）的访问端点和令牌服务(token services);<令牌服务>
     *
     * @Param:
     * @Return:
     */
    public AuthorizationServerTokenServices configure() throws Exception {
        // 令牌服务
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        // 客户端信息服务
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        // 是否产生刷新令牌
        defaultTokenServices.setReuseRefreshToken(true);
        // 令牌存储策略
        defaultTokenServices.setTokenStore(tokenStore);
        // 失效时间, 2小时
        defaultTokenServices.setAccessTokenValiditySeconds(7200);
        // 刷新令牌默认有效期3天
        defaultTokenServices.setRefreshTokenValiditySeconds(259200);
        return defaultTokenServices;
    }


}
