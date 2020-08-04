package com.bravelionet.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: Lionet
 * @Date 2020/7/17 22:41
 * @Description
 *  Environment : 整个项目的配置
 *
 * @Param:
 * @Return:
 */
@Mapper
@Component("testEnvironmentMapper")
public interface TestEnvironmentMapper {

    public String selectAll();
}
