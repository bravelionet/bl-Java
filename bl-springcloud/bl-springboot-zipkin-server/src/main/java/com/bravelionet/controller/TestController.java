package com.bravelionet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/zipkin/{id}")
    public String test(@PathVariable("id") Long id){
        System.out.println("id = " + id);
        return "dd";
    }
}
