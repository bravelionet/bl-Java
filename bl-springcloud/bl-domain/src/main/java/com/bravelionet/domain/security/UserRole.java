package com.bravelionet.domain.security;


import java.time.LocalDateTime;
import com.bravelionet.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色对应关系
 * </p>
 *
 * @author Lionet
 * @since 2020-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserRole extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 校色id
     */
    private Long roleId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 1: 启动. 0废弃
     */
    private Integer status;


}
