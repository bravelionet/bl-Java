package com.bravelionet.service;

import com.bravelionet.api.AuthenticationService;
import com.bravelionet.dao.PretendMysql;
import com.bravelionet.entity.AuthenticationRequest;
import com.bravelionet.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Authror Lionet
 * @Date 2020/8/5 0:04
 * @Description 用户认证登录,分配权限控制
 */
@Service
public class AuthenticationServiceImpl  implements AuthenticationService {

    /**
     * @Author: Lionet
     * @Date 2020/8/5 0:04
     * @Description 用户登录,校验账号密码及权限
     * @Param:
     * @Return:
     */
    @Override
    public User authentication(AuthenticationRequest authenticationRequest) {
        //校验参数是否为空
        if(authenticationRequest == null
                || StringUtils.isEmpty(authenticationRequest.getUsername())
                || StringUtils.isEmpty(authenticationRequest.getPassword())){
            throw new RuntimeException("账号和密码为空");
        }
        //根据账号去查询数据库,这里测试程序采用模拟方法
        User user = PretendMysql.getUserDto(authenticationRequest.getUsername());
        //判断用户是否为空
        if(user == null){
            throw new RuntimeException("查询不到该用户");
        }
        //校验密码
        if(!authenticationRequest.getPassword().equals(user.getPassword())){
            throw new RuntimeException("账号或密码错误");
        }
        //认证通过，返回用户身份信息
        return user;
    }

}
