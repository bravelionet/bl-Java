package com.bravelionet.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bravelionet.service.HobbyInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zookeeper")
public class ZookeeperClientController {


    @Autowired
    HobbyInterestService hobbyInterestServiceImpl;

    /**
     * @Author: Lionet
     * @Date 2020/7/30 14:23
     * @Description 使用 dubbo 调用
     * @Param:
     * @Return:
     */
    @GetMapping("/testDubboRpc/{id}")
    public String testDubboRpc(@PathVariable("id") Long id) {
        for (int i = 0; i < 5000; i++) {
            new Runnable() {
                @Override
                public void run() {
                    System.out.println("i = " + "i");
                    String s = hobbyInterestServiceImpl.testDubboRpc(id);
                }
            }.run();
        }
        return "s";
    }


    //  zookeeper  fegin 调用方式
    //   @Autowired
    //  ZookeeperServiceClinet zookeeperServiceClinet;



   /* @GetMapping("/client/{id}")
    public String client(@PathVariable("id") Long id) {
        String zookeeperService = zookeeperServiceClinet.getZookeeperService(id);
        System.out.println("id = " + id);
        return zookeeperService;
    }*/


}
