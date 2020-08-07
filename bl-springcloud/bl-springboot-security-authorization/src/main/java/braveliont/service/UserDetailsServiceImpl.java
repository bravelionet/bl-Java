package braveliont.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Authror Lionet
 * @Date 2020/8/6 11:42
 * @Description  自定义用户查询方式
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * @Author: Lionet
     * @Date 2020/8/6 11:42
     * @Description 根据用户名,查询用户信息, 重写 UserDetailsService,用户认证时可进行查询数据库校验
     * @Param:
     * @Return:
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("username = " + username);
        User.UserBuilder userDetails1 = User.withUsername("root");
        User.UserBuilder userDetails2 = userDetails1.password("root");
        User.UserBuilder authorities = userDetails2.authorities("root", "admin");
        UserDetails userDetails = authorities.build();

        return userDetails;
    }
}
