package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.user.UserMapper;
import com.example.demo.pojo.User;
@Service
public class UserService {
	@Autowired
    private UserMapper userMapper;
    public List<User> getUser() throws Exception {
        return userMapper.getUser();
    }
    //根据id删除用户
    public void deleteUser(int id) throws Exception {
        userMapper.deleteUser(id);
    }
    //新增用户
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }
	public User queryOne(int id) {
		// TODO Auto-generated method stub
		return userMapper.queryOne(id);
	}

}
