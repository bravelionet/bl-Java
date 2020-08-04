package com.bravelionet.service;


import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author: Lionet
 * @Date 2020/7/30 14:17
 * @Description 测试 dubbo 调用, 注意 @Service 注解归属 alibaba.dubbo 包
 * @Param:
 * @Return:
 */
@Service
public class HobbyInterestServiceImpl implements HobbyInterestService{

    @Reference
    HobbyInterestService hobbyInterestService;

    public String testDubboRpc(Long param) {
        String result = hobbyInterestService.testDubboRpc(param);
        System.out.println("param = " + param);
        return result;
    }
}
