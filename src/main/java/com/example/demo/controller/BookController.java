package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.JSON;
import com.example.demo.pojo.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService service;
	
	@RequestMapping("queryOneBook")
	public String queryOne(String guid) {
		return JSON.Encode(service.queryOne(guid));
	}
	
	@RequestMapping("queryAllBook")
	public String queryAll() {
		return JSON.Encode(service.getAllBook());
	}
	
	@RequestMapping("addBook")
	public String addBook(String bookName,double price,
			int amount) {
		Book book = new Book();
		book.setAmount(amount);
		book.setBookName(bookName);
		book.setPrice(price);
		book.setGuid(UUID.randomUUID().toString());
		service.addBook(book);
		return "添加书籍成功";
	}
	
	@RequestMapping("deleteBook")
	public String deleteBook(String guid) {
		service.deleteBook(guid);
		return "您已删除guid为["+guid+"]的数据";
	}
}
