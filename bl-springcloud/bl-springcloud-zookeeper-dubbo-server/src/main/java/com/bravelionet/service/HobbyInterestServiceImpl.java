package com.bravelionet.service;


import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Author: Lionet
 * @Date 2020/7/30 14:20
 * @Description dubbo 服务端, @Service 归属 alibaba.dubbo 包
 * @Param:
 * @Return:
 */
@Service
public class HobbyInterestServiceImpl implements HobbyInterestService {

    public String testDubboRpc(Long param) {
        System.out.println("param = " + param);
        return "服务端调用成功";
    }
}
