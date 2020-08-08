package com.bravelionet.service.security;

import com.bravelionet.domain.security.Permission;

import java.util.List;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:19
 * @Description   权限表 服务类
 */

public interface IPermissionService {

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:45
     * @Description 根据 权限Id,查询
     * @Param:
     * @Return:
     */
    public List<Permission> queryByIds(List<Long> permissionId);
}
