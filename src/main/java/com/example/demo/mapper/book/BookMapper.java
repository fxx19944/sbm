package com.example.demo.mapper.book;

import java.util.List;

import com.example.demo.pojo.Book;

public interface BookMapper{
	
	public List<Book> getAllBook();
	
	public void deleteBook(String guid); 
	
	public void addBook(Book book);
	
	public Book queryOne(String guid);
}