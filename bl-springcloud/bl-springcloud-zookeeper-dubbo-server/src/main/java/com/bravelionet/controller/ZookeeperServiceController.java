package com.bravelionet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zookeeper")
public class ZookeeperServiceController {


    @GetMapping("/service/{id}")
    public String client(@PathVariable("id") Long id){

        System.out.println("id = " + id);
        return "zookeeper service  返回信息";
    }



}
