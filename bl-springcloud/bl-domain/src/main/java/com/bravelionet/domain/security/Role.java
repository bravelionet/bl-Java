package com.bravelionet.domain.security;


import com.bravelionet.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Lionet
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Role extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String description;

    private Date createTime;

    private Date updateTime;

    /**
     * 1 : 启用, 0 废弃
     */
    private Integer status;


}
