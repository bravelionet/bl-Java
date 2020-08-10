package com.bravelionet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
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
     * @Description 密码编码器
     * 提供多种密码编码器, 方便模拟, 使用 NoOpPasswordEncoder 比较字符串方式
     * @Param:
     * @Return:
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(16); // 使用 BCrypt 进行加密, 密码强度 默认 10, 建议 16

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
        http.csrf().disable().authorizeRequests()
                /* .antMatchers("/manager/update").hasAuthority("root") // 设置资源访问权限  < 授权使用 @PreAuthorize代替 >
                 .antMatchers("/admin/query").hasAuthority("admin") // 设置资源访问权限*/
                .anyRequest().permitAll()//除了/**，其它的请求可以访问
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login-view") // 自己的登录页,spring security以重定向方式跳转到 /view-login
                .loginProcessingUrl("/loginUrl") // 标识处理登录的 URL( security 提供默认处理 路径,前端请求的地址)
                //   .successHandler(new ForwardAuthenticationSuccessHandler("/login-success?status=true"));
                .defaultSuccessUrl("/login-success")//自定义登录成功的页面地址
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login-out")
                .deleteCookies("JSESSIONID")
                .permitAll();
        ;


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
        manager.createUser(User.withUsername("root").password("root").authorities("root", "admin").build());
        manager.createUser(User.withUsername("admin").password("admin").authorities("admin").build());
        return manager;
    }


}