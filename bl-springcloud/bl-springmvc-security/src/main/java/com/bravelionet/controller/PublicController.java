package com.bravelionet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Authror Lionet
 * @Date 2020/8/5 15:56
 * @Description 公开数据
 */
@RestController
@RequestMapping("/static")
public class PublicController {


    /**
     * @Author: Lionet
     * @Date 2020/8/5 16:35
     * @Description 公开数据
     * @Param:
     * @Return:
     */
    @GetMapping(value = "/public/data",produces = {"text/plain;charset=UTF-8"})
    public String root(){
        return " 访问公开数据 ";
    }


}
