package com.bravelionet.service.security;

import com.bravelionet.domain.security.UserRole;

import java.util.List;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:20
 * @Description 用户角色对应关系 服务类
 */

public interface IUserRoleService {

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:20
     * @Description 获取 用户所持有的 role_id
     * @Param:
     * @Return:
     */
    List<Long> queryRoleIdByUserId(Long userId);


    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:20
     * @Description 获取 用户所持有的角色
     * @Param:
     * @Return:
     */
    List<UserRole> queryRoleByUserId(Long userId);

}