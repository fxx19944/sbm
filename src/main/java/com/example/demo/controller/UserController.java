package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.JSON;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("queryOne/{id}")
    public String queryOne(@PathVariable int id) throws Exception{
    	return JSON.Encode(userService.queryOne(id));
    }
  
    //显示用户
    @RequestMapping("list")
    public String queryAll() throws Exception {
        return JSON.Encode(userService.getUser());
    }
    //删除用户
    @RequestMapping("delete/{id}")
    public String deleteUser(@PathVariable int id) throws Exception {
        userService.deleteUser(id);
        return "你已经删掉了id为"+id+"的用户";
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