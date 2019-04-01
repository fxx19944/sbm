package com.example.demo.mapper.customer;

import com.example.demo.pojo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerMapper {
	@Select("select * from customer")
	@Results({
			@Result(column = "guid",property = "guid"),
			@Result(column = "customerName",property = "customerName"),
			@Result(column = "regesterTime",property = "regesterTime"),
			@Result(column = "balance",property = "balance")
	})
	public List<Customer> queryAllCustomer();
	@Select("select * from customer where guid=#{guid}")
	@Results({
			@Result(column = "guid",property = "guid"),
			@Result(column = "customerName",property = "customerName"),
			@Result(column = "regesterTime",property = "regesterTime"),
			@Result(column = "balance",property = "balance")
	})
	public Customer queryOneCustomer(String guid);
	@Insert("insert into customer(guid,customerName,regesterTime,balance) values(#{guid},#{customerName},#{regesterTime},#{balance})")
	public void addCustomer(Customer customer);
	@Delete("delete from customer where guid =#{guid}")
	public void delCustomer(String guid);
}
