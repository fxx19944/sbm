package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.book.BookMapper;
import com.example.demo.pojo.Book;

@Service
public class BookService {
	@Autowired
	private BookMapper dao;
	
	public List<Book> getAllBook(){
		return dao.getAllBook();
	}
	
	public void deleteBook(String guid) {
		dao.deleteBook(guid);
	}
	
	public void addBook(Book book) {
		dao.addBook(book);
	}
	
	public Book queryOne(String guid) {
		return dao.queryOne(guid);
	}
}
