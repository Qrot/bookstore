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
	
	/**
	 * 分类显示
	 * @param kind
	 * @param offset
	 * @return
	 */
	@GetMapping("/kind")
	@ResponseBody
	public List<Book> kindShow(
			@RequestParam(name="k", required=false) String kind,
			@RequestParam(name="o", defaultValue="0", required=false) int offset) {

		return bookService.kindShow(kind, offset);
	}
	
	/**
	 * 获取特定书籍的所有信息
	 * @param bookId
	 * @return
	 */
	@GetMapping("/{bookId}")
	@ResponseBody
	public Book showBookDetailInfo(@PathVariable int bookId) {
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
			@RequestParam(name="keyWord", defaultValue="' '", required=false) String keyWord
	) {
		
		return bookService.selectBook(keyWord);
		
	}
}
