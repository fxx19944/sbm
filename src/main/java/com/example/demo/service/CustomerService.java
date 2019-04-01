package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.customer.CustomerMapper;
import com.example.demo.pojo.Customer;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper dao;
	
	public List<Customer> queryAll(){
		return dao.queryAllCustomer();
	}
	
	public Customer queryOne(String guid) {
		return dao.queryOneCustomer(guid);
	}
	
	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}
	
	public void delCustomer(String guid) {
		dao.delCustomer(guid);
	}
}
