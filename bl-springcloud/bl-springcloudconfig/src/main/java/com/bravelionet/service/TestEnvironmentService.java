package com.bravelionet.service;

import com.bravelionet.dao.TestEnvironmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Lionet
 * @Date 2020/7/17 22:41
 * @Description
 *
 *
 * @Param:
 * @Return:
 */
@Service
public class TestEnvironmentService {


  @Autowired
  TestEnvironmentMapper testEnvironmentMapper;


    public void test() {
        String s = testEnvironmentMapper.selectAll();
        System.out.println("s = " + s);
    }
}
