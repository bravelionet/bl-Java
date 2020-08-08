package com.bravelionet.domain.security;

import com.bravelionet.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lionet
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 角色 Id
     */
    private Long roleId;

    /**
     * 权限 Id
     */
    private Long permissionId;


}
