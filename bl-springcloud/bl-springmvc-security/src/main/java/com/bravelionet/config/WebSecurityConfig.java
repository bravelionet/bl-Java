package com.bravelionet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Authror Lionet
 * @Date 2020/8/5 15:58
 * @Description Spring Security配置类,需加载到 applicationContent中
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
        return NoOpPasswordEncoder.getInstance();
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

       /*
        // 标识已经授权的权限
        GrantedAuthority grantedAuthority= new GrantedAuthority() {
           @Override
           public String getAuthority() {
               return null;
           }
       };*/
       /*
        // 使用 GrantedAuthority 向用户受理多种权限
        GrantedAuthority root = new SimpleGrantedAuthority("root");
        GrantedAuthority admin = new SimpleGrantedAuthority("admin");
        List<GrantedAuthority> rootGrantedAuthorityList = new ArrayList<>();
        rootGrantedAuthorityList.add(root);
        rootGrantedAuthorityList.add(admin);
        List<GrantedAuthority> adminGrantedAuthorityList = new ArrayList<>();
        adminGrantedAuthorityList.add(admin);
        manager.createUser(User.withUsername("root").password("root").authorities(rootGrantedAuthorityList).build());
        manager.createUser(User.withUsername("admin").password("admin").authorities(adminGrantedAuthorityList).build());
        */
        // User 是 Security包下
        manager.createUser(User.withUsername("root").password("root").authorities("root", "admin").build());
        manager.createUser(User.withUsername("admin").password("admin").authorities("admin").build());

        return manager;
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
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                expressionInterceptUrlRegistry = http.authorizeRequests();
        expressionInterceptUrlRegistry
                .antMatchers("/accept/root/update").hasAuthority("root") // 设置资源访问权限
                .antMatchers("/accept/admin/query").hasAuthority("admin") // 设置资源访问权限
                .antMatchers("/accept/**").authenticated()//所有 /accept/** 的请求必须认证通过
                .anyRequest().permitAll()//除了/accept/**，其它的请求可以访问
                .and()
                .formLogin()//允许表单登录
                .successForwardUrl("/accept/login-success");//自定义登录成功的页面地址

    }
}
