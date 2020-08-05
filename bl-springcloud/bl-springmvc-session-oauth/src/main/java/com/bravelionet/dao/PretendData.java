package com.bravelionet.dao;

import com.bravelionet.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Authror Lionet
 * @Date 2020/8/5 15:02
 * @Description  模拟数据用户信息
 */

@Component
public class PretendData {

    //根据账号查询用户信息
    public static UserDto getUserDto(String userName){
        return userMap.get(userName);
    }
    //用户信息
    private  static Map<String,UserDto> userMap = new HashMap<>();
    {
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("root");//这个root我们人为让它和/oauth/root,admin对应
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("admin");//这个admin我们人为让它和/oauth/admin对应
        userMap.put("zhangsan",new UserDto("1010","zhangsan","123","张三","133443",authorities1));
        userMap.put("lisi",new UserDto("1011","lisi","456","李四","144553",authorities2));
    }
}
