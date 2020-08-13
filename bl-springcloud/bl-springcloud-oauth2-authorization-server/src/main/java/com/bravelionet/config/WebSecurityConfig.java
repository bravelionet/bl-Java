package com.bravelionet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Authror Lionet
 * @Date 2020/8/5 15:58
 * @Description Spring Security配置类,需加载到 applicationContent中
 */

@Configuration
// 开启授权
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/5 15:58
     * @Description 定义用户信息服务（查询用户信息）
     * UserDetailsService : 记录用户信息 bean
     * InMemoryUserDetailsManager :
     *      Spring Security的InMemoryUserDetailsManager实现UserDetailsService为在内存中检索到的基于用户名/密码的身份验证提供支持
     * @Param:
     * @Return:
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // User 是 Security包下
        manager.createUser(User.withUsername("root").password(passwordEncoder().encode("root")).authorities("root", "admin").build());
        manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("admin")).authorities("admin").build());
        return manager;
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/5 15:58
     * @Description 密码编码器
     * 提供多种密码编码器, 方便模拟, 使用 NoOpPasswordEncoder 比较字符串方式
     * @Param:
     * @Return:
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        //    return   NoOpPasswordEncoder.getInstance(); // 使用 BCrypt 进行加密, 密码强度 默认 10, 建议 16
        return new BCryptPasswordEncoder();
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/5 15:59
     * @Description 安全拦截机制（最重要）
     * @Param:
     * @Return:
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")
                .anyRequest().authenticated()
                .and()
                .formLogin();

    }


}