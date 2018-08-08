package com.qrot.bookstore.background.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrot.bookstore.background.model.Book;
import com.qrot.bookstore.background.service.BackgroundService;

@Controller
@RequestMapping
public class BookController {

	@Autowired
	BackgroundService service;
	
	@PostMapping("/addbook")
	@ResponseBody
	public String add(Book book) {
		
		service.addBook(book);
		
		//返回状态码
		return "{msg: 'ok'}";
	}
}
