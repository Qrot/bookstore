package com.qrot.bookstore.reception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrot.bookstore.reception.model.Book;
import com.qrot.bookstore.reception.service.BookService;

/**
 * 
 * @author TanZhiHua 2018年8月6日10点53分
 */
@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	/**
	 * 显示所有书籍信息
	 * @return
	 */
	@GetMapping
	@ResponseBody
	public List<Book> show() {

		return bookService.show();
	}
	
	@GetMapping("/kind")
	@ResponseBody
	public List<Book> kindShow(
			@RequestParam(name="k", required=false) String kind,
			@RequestParam(name="o", defaultValue="0", required=false) int offset) {

		return bookService.kindShow(kind, offset);
	}
}
