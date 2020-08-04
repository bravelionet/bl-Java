package com.bravelionet.client;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

// 启动类需增加 @EnableFeignClients 指定扫跑
// 切记 spring.application.name 服务名不可有 _
//@FeignClient("bl-springcloudzookeeperserver")
public interface ZookeeperServiceClinet {

    @GetMapping("/zookeeper/service/{id}")
    public @ResponseBody String getZookeeperService(@PathVariable("id") Long id);
}
