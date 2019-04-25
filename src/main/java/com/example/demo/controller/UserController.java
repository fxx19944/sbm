package com.example.demo.controller;

import com.example.demo.common.JSON;
import com.example.demo.pojo.User;
import com.example.demo.redis.RedisUtil;
import com.example.demo.service.UserService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil ru;
    
    @RequestMapping("queryOne/{id}")
    public String queryOne(@PathVariable int id) throws Exception{
    	return JSON.Encode(userService.queryOne(id));
    }
  
    //显示用户
    @RequestMapping("list")
    public String queryAll() throws Exception {
        String str = (String)ru.get("list");
        if(!StringUtil.isNullOrEmpty(str)){
            return str;
        }
        String strList = JSON.Encode(userService.getUser());
        ru.set("list",strList);
        return strList;
    }
    //删除用户
    @RequestMapping("delete/{id}")
    public String deleteUser(@PathVariable int id) throws Exception {
        userService.deleteUser(id);
        return "你已经删掉了id为"+id+"用户";
    }
    //增加用户
    @RequestMapping("addUser")
    public String insertUser(String username,int age) throws Exception {
    	User user = new User();
        user.setAge(age);
        user.setUsername(username);
        userService.addUser(user);
        return "增加用户";
    }
}