package com.example.demo.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.JSON;
import com.example.demo.pojo.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("queryOneCustomer")
	public String queryOne(String guid) {
		return JSON.Encode(service.queryOne(guid));
	}
	
	@RequestMapping("queryAllCustomer")
	public String queryAllCustomer() {
		return JSON.Encode(service.queryAll());
	}
	@RequestMapping("addCustomer")
	public String addCustomer(String customerName) {
		Customer customer = new Customer();
		customer.setBalance(0.0);
		customer.setGuid(UUID.randomUUID().toString());
		customer.setRegesterTime(new Date());
		customer.setCustomerName(customerName);
		service.addCustomer(customer);
		return "添加顾客成功";
	}
	
	@RequestMapping("delCustomer")
	public String delCustomer(String guid) {
		service.delCustomer(guid);
		return "添加顾客成功";
	}
}
