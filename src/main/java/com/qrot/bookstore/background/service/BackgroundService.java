package com.qrot.bookstore.background.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrot.bookstore.background.mapper.BookMapper;
import com.qrot.bookstore.background.model.Book;
@Service
public class BackgroundService {

	@Autowired
	BookMapper bookMapper;
	
	//新增书籍
	public void addBook(Book book) {

		bookMapper.addBookInfo(book);
		bookMapper.addBook(book);
	}
}
