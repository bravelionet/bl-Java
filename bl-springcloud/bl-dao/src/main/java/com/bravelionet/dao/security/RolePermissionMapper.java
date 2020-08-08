package com.bravelionet.dao.security;


import com.bravelionet.domain.security.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:30
 * @Description 角色权限对应 Mapper 接口
 */

@Mapper
public interface RolePermissionMapper {

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:26
     * @Description 根据 角色ID 或者 权限
     * @Param:
     * @Return:
     */
    List<RolePermission> queryPermissionByRoleId(@Param("roleIdList") List<Long> roleId);

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:26
     * @Description 根据 角色ID 或者 权限Id
     * @Param:
     * @Return:
     */
    List<Long> queryPermissionIdByRoleId(@Param("roleIdList") List<Long> roleId);
}
