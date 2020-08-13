package com.bravelionet.service;

import com.bravelionet.domain.security.Permission;
import com.bravelionet.domain.security.User;
import com.bravelionet.service.security.IPermissionService;
import com.bravelionet.service.security.IRolePermissionService;
import com.bravelionet.service.security.IUserRoleService;
import com.bravelionet.service.security.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Authror Lionet
 * @Date 2020/8/6 11:42
 * @Description 自定义用户查询方式
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IPermissionService iPermissionService;
    @Autowired
    IRolePermissionService iRolePermissionService;
    @Autowired
    IUserRoleService iUserRoleService;
    @Autowired
    IUserService iUserService;
    Logger looger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


    /**
     * @Author: Lionet
     * @Date 2020/8/6 11:42
     * @Description 根据用户名, 查询用户信息, 重写 UserDetailsService,用户认证时可进行查询数据库校验
     * @Param:
     * @Return:
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        looger.error(" 校验用户 认证信息 [userNmae:{}]", username);
     /*   System.out.println("username = " + username);
        User.UserBuilder userDetails1 = User.withUsername("root");
        User.UserBuilder userDetails2 = userDetails1.password("root");
        User.UserBuilder authorities = userDetails2.authorities("root", "admin");
        UserDetails userDetails = authorities.build();*/
        User user = iUserService.queryByName(username);
        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getUserName());
        userBuilder = userBuilder.password(user.getPassword());
        // 获取用户权限
        List<String> permissionList = this.queryUserPermission(user);
        // 无权限
        if (Objects.isNull(permissionList) || permissionList.size() == 0) {
            UserDetails userDetails = userBuilder.build();
            return userDetails;
        }
        // 转换
        String[] permissionArray = new String[permissionList.size()];
        permissionList.toArray(permissionArray);

        // 存放权限
        userBuilder = userBuilder.authorities(permissionArray);
        // 产生一个 org.springframework.security.core.userdetails.User
        UserDetails userDetails = userBuilder.build();
        return userDetails;
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/7 18:02
     * @Description 根据 user_id 获取用户持有权限
     *   查询权限
     *     1. 根据userId 查询 role_id
     *     2. 根据 role_id 查询 permission_id
     *     3. 根据 permission_id 查询资源(个人设想是否可以使用 redis呢, 有效时间 30分钟)
     * @Param:
     * @Return:
     */
    private List<String> queryUserPermission(User user) {
        List<Long> roleId = iUserRoleService.queryRoleIdByUserId(user.getId());
        if ( Objects.isNull(roleId) || roleId.size() == 0) {
            // 无角色,新用户默认存在 游客角色
            return null;
        }
        List<Long> permissionIdList = iRolePermissionService.queryPermissionIdByRoleId(roleId);
        if ( Objects.isNull(permissionIdList) || permissionIdList.size() == 0) {
            // 无绑定权限,新用户默认存在 游客权限
            return null;
        }
        List<Permission> permissionList = iPermissionService.queryByIds(permissionIdList);

        if (Objects.isNull(permissionList) || permissionList.size() == 0) {
            // 查询到权限
            return null;
        }

        return permissionList.stream()
                .map(permission -> permission.getCode())
                .filter(permissionCode -> !permissionCode.equals(""))
                .collect(Collectors.toList());

    }
}
