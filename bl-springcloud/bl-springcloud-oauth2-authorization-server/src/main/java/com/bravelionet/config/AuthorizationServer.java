package com.bravelionet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @Author: Lionet
 * @Date 2020/8/10 13:18
 * @Description 1. 配置客户端详情信息
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

     // 用来配置客户端详情服务（ClientDetailsService），客户端详情信息在
            这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    }

     //用来配置令牌（token）的访问端点和令牌服务(token services)
     // 申请令牌的 URL(端点)
     // 令牌怎么发放(令牌服务)
     // TokenStore 令牌存储方案
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    }

    // 配置安全策略
    // 那些人客户申请令牌
     public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    }

    */


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private ClientDetailsService clientDetailsService; // 客户端配置
    @Autowired
    private TokenStore tokenStore; // 令牌储存策略

    @Autowired
    JwtAccessTokenConverter accessTokenConverter;


    @Autowired
    PasswordEncoder passwordEncoder;
    
    

    /**
     * @Author: Lionet
     * @Date 2020/8/10 11:51
     * @Description 配置客户端详情信息
     * <p>
     * 1. 谁来申请令牌
     * 2. 客户端密钥
     * 3. 可以访问的资源列表
     * 4. 授权类型
     * 5. ......
     * @Param:
     * @Return:
     */

    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
      /*  clients.inMemory()//  使用in‐memory存储(内存方式)
                .withClient("bl_client")//  允许谁来申请令牌, 客户端 Id
                .secret(new BCryptPasswordEncoder().encode("bl_secret")) // 客户端密钥
                .resourceIds("res1") // 客户端可以访问的资源列表(资源服务的Id)
                .authorizedGrantTypes("authorization_code",
                        "password", "client_credentials",
                        "implicit", "refresh_token")//  该client允许的授权类型 authorization_code,password,refresh_token,implicit,client_credentials
                .scopes("all")//  允许的授权范围(客户端的权限)
                .autoApprove(false)// false 在申请授权码模式,就会跳转到授权页面
                .redirectUris("http://www.baidu.com");//加上验证回调地址*/
        clients.withClientDetails(clientDetailsService);
    }



    /**
     * @Author: Lionet
     * @Date 2020/8/13 14:40
     * @Description 客户端配置信息存储DB, 配置数据库连接
     * @Param:
     * @Return:
     */
    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService)
                clientDetailsService).setPasswordEncoder(passwordEncoder);
       
        return clientDetailsService;
    }





    /**
     * @Author: Lionet
     * @Date 2020/8/10 14:11
     * @Description 令牌访问端点配置
     * AuthorizationServerEndpointsConfigurer
     * .pathMapping()AuthorizationServerEndpointsConfigurer
     * 这个配置对象有一个叫做 pathMapping() 的方法用来配置端点URL链接
     * 第一个参数： String 类型的，这个端点URL的默认链接。
     * 第二个参数： String 类型的，你要进行替代的URL链接
     * 可以作为这个 pathMapping() 方法的第一个参数
     * /oauth/authorize ：授权端点。
     * /oauth/token ：令牌端点。
     * /oauth/confirm_access ：用户确认授权提交端点。
     * /oauth/error ：授权服务错误信息端点。
     * /oauth/check_token ：用于资源服务访问的令牌解析端点。
     * /oauth/token_key ：提供公有密匙的端点，如果你使用JWT令牌的话
     * @Param:
     * @Return:
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
                .authenticationManager(authenticationManager)// 认证管理器，当你选择了资源所有者密码（password）授权类型
                .authorizationCodeServices(authorizationCodeServices) // 授权码类型模式
                .tokenServices(tokenService()) // 设置令牌 服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST); // form表单 post请求
    }


    /**
     * @Author: Lionet
     * @Date 2020/8/10 14:08
     * @Description 配置安全策略
     * @Param:
     * @Return:
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .tokenKeyAccess("permitAll()")  //oauth/token_key是公开; tokenkey这个endpoint当使用JwtToken且使用非对称加密时，资源服务用于获取公钥而开放的，这里指这个endpoint完全公开。
                .checkTokenAccess("permitAll()") //oauth/check_token公开
                .allowFormAuthenticationForClients();  //表单认证（申请令牌）

    }


    //设置授权码模式的授权码如何存取，暂时采用内存方式
/*
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }
*/

    /**
     * @Author: Lionet
     * @Date 2020/8/13 14:44
     * @Description 设置授权码模式的授权码如何存取，暂时采用数据库方式
     * @Param:
     * @Return:
     */
    @Bean
    public  AuthorizationCodeServices  authorizationCodeServices(DataSource  dataSource)  {
        return  new  JdbcAuthorizationCodeServices(dataSource);//设置授权码模式的授权码如何存取               
    }
    /**
     * @Author: Lionet
     * @Date 2020/8/10 12:09
     * @Description 用来配置令牌（token）的访问端点和令牌服务(token services);<令牌服务>
     * @Param:
     * @Return:
     */
    @Bean
    public AuthorizationServerTokenServices tokenService() {
        // 令牌服务
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        // 客户端信息服务
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        // 是否产生刷新令牌
        defaultTokenServices.setReuseRefreshToken(true);
        // 令牌存储策略
        defaultTokenServices.setTokenStore(tokenStore);

        // 配置 JWT
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(accessTokenConverter));
        defaultTokenServices.setTokenEnhancer(tokenEnhancerChain);
        // 失效时间, 2小时
        defaultTokenServices.setAccessTokenValiditySeconds(7200);
        //   刷新令牌默认有效期3天
        defaultTokenServices.setRefreshTokenValiditySeconds(259200);
        return defaultTokenServices;
    }

}

