package com.bravelionet.dao.security;


import com.bravelionet.domain.security.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:30
 * @Description 权限表 Mapper 接口
 */
@Mapper
public interface PermissionMapper {

    /**
     * @Author: Lionet
     * @Date 2020/8/8 23:10
     * @Description 根据 权限id 查询权限详情
     * @Param:
     * @Return:
     */
    List<Permission> queryByIds(@Param("permissionIdList") List<Long> permissionIdList);
}
