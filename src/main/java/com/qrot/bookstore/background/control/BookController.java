package com.qrot.bookstore.background.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrot.bookstore.background.model.Book;
import com.qrot.bookstore.background.service.BackgroundService;

@Controller
@RequestMapping
public class BookController {

	@Autowired
	BackgroundService service;
	
	/**
	 * 新增书籍
	 * @param book
	 * @return
	 */
	@PostMapping("/addbook")
	@ResponseBody
	public String add(Book book) {
		
		service.addBook(book);
		//返回状态码
		return "{msg: 'ok'}";
	}
	
	/**
	 * 书籍上架
	 * @param id
	 * @return
	 */
	@PutMapping("/recoverbook/{id}")
	@ResponseBody
	public String recoverBook(@PathVariable int id) {
		service.recoverBook(id);
		return "{msg:'ok'}";
	}
	
	/**
	 * 书籍下架
	 * @param bookid
	 * @return
	 */
	@PutMapping("/removebook/{bookid}")
	@ResponseBody
	public String removeBook(@PathVariable int bookid) {
		service.removeBook(bookid);
		return "{msg:'ok'}";
	}
	
	/**
	 * 修改书籍变动信息
	 * @param bookid
	 * @param book
	 * @return
	 */
	@PutMapping("/updatebook/{bookid}")
	@ResponseBody
	public String update(@PathVariable int bookid, Book book) {
		service.updateBook(book);
		return "{msg: 'ok'}";
	}
	
	@GetMapping("/getbook/{bookid}")
	@ResponseBody
	public Book getOneBook(@PathVariable int bookid) {
		return service.getOneBook(bookid);
	}
	
	/**
	 * 获得指定行的书籍信息
	 * 
	 * @param start
	 * @param offset
	 * @return
	 */
	@GetMapping("/getbook/{bookid}")
	@ResponseBody
	public List<Book> getSomeBook(
			@RequestParam(name="k", defaultValue="10",required=false) int start,
			@RequestParam(name="o", defaultValue="0", required=false) int offset){
		return service.getSomeBook(start, offset);
	}
	
	/**
	 * 获得某个类别的十行书籍信息
	 * @param kind  类别
	 * @param offset 偏移量
	 * @return
	 */
	@GetMapping("/getbook/{bookid}")
	@ResponseBody
	public List<Book> getKindBook(
			@RequestParam(name="k", required=true) String kind,
			@RequestParam(name="o", defaultValue="0", required=false) int offset){
		return service.getKindBook(kind, offset);
	}
}
