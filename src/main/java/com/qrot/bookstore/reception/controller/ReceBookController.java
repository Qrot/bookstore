package com.qrot.bookstore.reception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrot.bookstore.reception.model.Book;
import com.qrot.bookstore.reception.service.ReceBookService;

/**
 * 
 * @author TanZhiHua 2018年8月6日10点53分
 */
@Controller
@RequestMapping("/book")
public class ReceBookController {

	@Autowired
	ReceBookService bookService;

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
	
	@GetMapping("/{bookId}")
	@ResponseBody
	public Book showBookDetailInfo(
			@PathVariable int bookId
	) {
		return bookService.showBookDetailInfo(bookId);
	}
	
	/**
	 * 模糊查询搜索书籍
	 * @param price
	 * @param score
	 * @param name
	 * @param author
	 * @param publish
	 * @param kind
	 * @param publTime
	 * @return
	 */
	@GetMapping("/select")
	@ResponseBody
	public List<Book> selectBook(
			@RequestParam(name="pric", defaultValue="' '", required=false) String price,
			@RequestParam(name="scor", defaultValue="' '", required=false) String score,
			@RequestParam(name="name", defaultValue="' '", required=false) String name,
			@RequestParam(name="auth", defaultValue="' '", required=false) String author,
			@RequestParam(name="publ", defaultValue="' '", required=false) String publish,
			@RequestParam(name="kind", defaultValue="' '", required=false) String kind,
			@RequestParam(name="time", defaultValue="' '", required=false) String publTime
	) {
		
		return bookService.selectBook(price, score, name, author, publish, kind, publTime);
		
	}
}
