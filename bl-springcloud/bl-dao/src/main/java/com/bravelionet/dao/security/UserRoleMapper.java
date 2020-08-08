package com.bravelionet.dao.security;


import com.bravelionet.domain.security.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:29
 * @Description 用户角色对应关系 Mapper 接口
 */
@Mapper
public interface UserRoleMapper {

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:23
     * @Description 根据 userId 获取 role_id
     * @Param:
     * @Return:
     */
    List<Long> queryRoleIdByUserId(@Param("userId") Long userId);

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:16
     * @Description 根据 userId 查询用户所持有的角色
     * @Param:
     * @Return:
     */
    List<UserRole> queryRoleByUserId(@Param("userId") Long userId);




}
