package com.bravelionet.service;


import com.bravelionet.dao.security.*;
import com.bravelionet.domain.security.UserRole;
import com.bravelionet.service.security.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色对应关系 服务实现类
 * </p>
 *
 * @author Lionet
 * @since 2020-08-07
 */
@Service
public class UserRoleServiceImpl  implements IUserRoleService {
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
     * @Date 2020/8/7 17:21
     * @Description 获取用户所持有的 role_id
     * @Param:
     * @Return:
     */
    @Override
    public List<Long> queryRoleIdByUserId(Long userId) {

        List<Long> userRoleIdList = userRoleMapper.queryRoleIdByUserId(userId);

        return userRoleIdList;
    }

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:15
     * @Description 根据 userID, 查询角色Id
     * @Param:
     * @Return:
     */
    @Override
    public List<UserRole> queryRoleByUserId(Long userId) {

        List<UserRole> userRoleList = userRoleMapper.queryRoleByUserId(userId);
        return userRoleList;

    }


}
