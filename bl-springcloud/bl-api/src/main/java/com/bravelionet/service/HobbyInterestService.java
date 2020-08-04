package com.bravelionet.service;

/**
 * @Author: Lionet
 * @Date 2020/7/30 14:11
 * @Description 测试 dubbo 调用
 *
 * 服务消费者和服务提供者, 同时实现此接口需注意 dubbo注解 和 SpringBean 注解;
 * @Param:
 * @Return:
 */
public interface HobbyInterestService {


    public String testDubboRpc(Long param);
}
