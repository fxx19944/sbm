package com.example.demo.mapper.user;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //获取用户名单
    @Select("select * from user")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "age",property = "age")
    })
    public List<User> getUser() throws Exception;
    //根据id删除用户
    @Delete("delete from user where id =#{id}")
    public void deleteUser(int id)throws Exception;
    //新增用户
    @Insert("insert into user(id,username,age)values(#{id},#{username},#{age})")
    public void addUser(User user)throws Exception;
    //查询某一个数据
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "age",property = "age")
    })
	public User queryOne(int id);
}
