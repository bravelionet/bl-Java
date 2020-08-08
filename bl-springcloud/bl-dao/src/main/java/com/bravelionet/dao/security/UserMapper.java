package com.bravelionet.dao.security;


import com.bravelionet.domain.security.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Authror Lionet
 * @Date 2020/8/7 16:30
 * @Description 用户 Mapper 接口
 */
@Mapper
@Component("userMapper")
public interface UserMapper {

    User queryByName(@Param("userName") String userName);
}
