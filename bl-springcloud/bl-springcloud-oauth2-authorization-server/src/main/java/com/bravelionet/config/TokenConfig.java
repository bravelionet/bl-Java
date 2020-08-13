package com.bravelionet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Author: Lionet
 * @Date 2020/8/10 12:05
 * @Description 配置令牌存储策略
 * @Param:
 * @Return:
 */
@Configuration
public class TokenConfig {

    // 密钥, 须和 客户端一样
    private String SIGNING_KEY = "bl_jwt_token";
    /**
     * @Author: Lionet
     * @Date 2020/8/10 12:07
     * @Description 配置 令牌储存策略
     * 提供四种储存方式
     * @Param:
     * @Return:
     */
    @Bean
    public TokenStore tokenStore() {

        // 基于 JWT
        JwtTokenStore jwtTokenStore = new JwtTokenStore(accessTokenConverter());

        // 在内存中存储令牌的令牌服务的实现
        //InMemoryTokenStore inMemoryTokenStore = new InMemoryTokenStore();

        return jwtTokenStore;
    }


    /**
     * @Author: Lionet
     * @Date 2020/8/13 13:52
     * @Description 配置 Jwt,生成策略
     * @Param:
     * @Return:
     */
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
     JwtAccessTokenConverter converter =  new JwtAccessTokenConverter();
     converter.setSigningKey(SIGNING_KEY); //对称秘钥，资源服务器使用该秘钥来验证
     return converter;
     }















}



