package com.bravelionet.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/com/bravelionet")
public class TestController {


     @GetMapping("/test/{bl}")
    public @ResponseBody  String  test(@PathVariable("bl") String bl){
        System.out.println("bl = " + bl);
        return bl;
    }
}
