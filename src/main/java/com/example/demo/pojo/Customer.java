package com.example.demo.pojo;

import java.util.Date;

public class Customer {
	private String guid;
	private String customerName;
	private Date regesterTime;
	private double balance;
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getRegesterTime() {
		return regesterTime;
	}
	public void setRegesterTime(Date regesterTime) {
		this.regesterTime = regesterTime;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}	
