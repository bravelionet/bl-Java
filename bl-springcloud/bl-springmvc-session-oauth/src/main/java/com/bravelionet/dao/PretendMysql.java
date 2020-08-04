package com.bravelionet.dao;

import com.bravelionet.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Lionet
 * @Date 2020/8/5 0:07
 * @Description 模拟 用户 mysql 数据
 * @Param:
 * @Return:
 */
@Component
public class PretendMysql {

    //根据账号查询用户信息
    public static User getUserDto(String userName){
        return userMap.get(userName);
    }
    //用户信息
    private static Map<String,User> userMap = new HashMap<>();
    {
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("root");//这个p1我们人为让它和/root/update,query对应
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("user");//这个p2我们人为让它和/root/query对应
        userMap.put("zhangsan",new User("1010","zhangsan","123","张三","133443",authorities1));
        userMap.put("lisi",new User("1011","lisi","456","李四","144553",authorities2));
    }

}
