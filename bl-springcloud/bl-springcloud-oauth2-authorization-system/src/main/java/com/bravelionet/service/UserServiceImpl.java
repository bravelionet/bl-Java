package com.bravelionet.service;


import com.bravelionet.dao.security.*;
import com.bravelionet.domain.security.User;
import com.bravelionet.service.security.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:23
 * @Description 用户服务实现类
 */
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;

    /**
     * @Author: Lionet
     * @Date 2020/8/7 16:23
     * @Description 根据用户昵称, 查询用户信息
     * @Param: 用户昵称, 确保唯一性
     * @Return:
     */
    @Override
    public User queryByName(String name) {
        logger.error(" 校验用户 认证信息 [userNmae:{}]", name);
        User user = userMapper.queryByName(name);
        if (user != null) {
            return user;
        }
        return null;
    }
}
