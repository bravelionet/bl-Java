package com.bravelionet.domain.security;


import java.util.Date;

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
public class User extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户昵称,唯一
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String fullname;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;


}
