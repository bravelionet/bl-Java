package com.bravelionet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Author: Lionet
 * @Date 2020/8/10 12:05
 * @Description 配置令牌存储策略
 * @Param:
 * @Return:
 */
@Configuration
public class TokenConfig {


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

        // 在内存中存储令牌的令牌服务的实现
        InMemoryTokenStore inMemoryTokenStore = new InMemoryTokenStore();

        return inMemoryTokenStore;
    }
}
