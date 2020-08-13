package com.bravelionet.service;


import com.bravelionet.dao.security.PermissionMapper;
import com.bravelionet.domain.security.Permission;
import com.bravelionet.service.security.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Lionet
 * @since 2020-08-07
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    PermissionMapper permissionMapper;

    /**
     * @Author: Lionet
     * @Date 2020/8/7 17:45
     * @Description 根据 权限Id,查询
     * @Param:
     * @Return:
     */
    @Override
    public List<Permission> queryByIds(List<Long> permissionIdList) {
        List<Permission> permissionList = permissionMapper.queryByIds(permissionIdList);
        return permissionList;
    }
}
