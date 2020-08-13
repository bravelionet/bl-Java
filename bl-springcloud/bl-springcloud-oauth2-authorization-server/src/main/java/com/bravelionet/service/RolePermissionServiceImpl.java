package com.bravelionet.service;

import com.bravelionet.dao.security.*;
import com.bravelionet.domain.security.RolePermission;
import com.bravelionet.service.security.IRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lionet
 * @since 2020-08-07
 */
@Service
public class RolePermissionServiceImpl   implements IRolePermissionService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Autowired
    UserRoleMapper userRoleMapper;
    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:26
     * @Description 根据 角色ID 或者 权限Id
     * @Param:
     * @Return:
     */
    @Override
    public List<Long> queryPermissionIdByRoleId(List roleId) {
        List<Long> rolePermissionIdList =  rolePermissionMapper.queryPermissionIdByRoleId(roleId);
        return rolePermissionIdList;
    }


    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:26
     * @Description 根据 角色ID 或者 权限
     * @Param:
     * @Return:
     */
    @Override
    public List<RolePermission> queryPermissionByRoleId(List roleId) {
        List<RolePermission> rolePermissionList =  rolePermissionMapper.queryPermissionByRoleId(roleId);
        return rolePermissionList;
    }
}
