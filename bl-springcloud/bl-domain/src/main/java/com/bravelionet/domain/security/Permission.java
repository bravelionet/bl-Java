package com.bravelionet.domain.security;
import com.bravelionet.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Lionet
 * @since 2020-08-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Permission  extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Long id;

    /**
     * 权限标识符
     */
    private String code;

    /**
     * 描述
     */
    private String description;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 1 : 启用, 0 废弃
     */
    private Integer status;


}
