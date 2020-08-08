package com.bravelionet.service.security;


import com.bravelionet.domain.security.RolePermission;

import java.util.List;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:19
 * @Description  角色权限对应
 */

public interface IRolePermissionService  {

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:26
     * @Description 根据 多个角色ID 或者 权限Id
     * @Param:
     * @Return:
     */
    public List<Long> queryPermissionIdByRoleId(List roleId);

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:26
     * @Description 根据 角色ID 或者 权限
     * @Param:
     * @Return:
     */
    public List<RolePermission> queryPermissionByRoleId(List roleId);
}
