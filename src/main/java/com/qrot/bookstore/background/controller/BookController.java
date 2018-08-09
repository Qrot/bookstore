package com.qrot.bookstore.background.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrot.bookstore.background.model.Book;
import com.qrot.bookstore.background.service.BackBookService;

@RestController
@RequestMapping("/api/1")
public class BookController {

	@Autowired
	BackBookService service;
	
	/**
	 * 新增书籍
	 * @param book
	 * @return
	 */
	@PostMapping(path="/addbook",consumes="application/json",produces="application/json")
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
	@PutMapping(path="/recoverbook/{id}",consumes="application/json",produces="application/json")
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
	@PutMapping(path="/removebook/{bookid}",consumes="application/json",produces="application/json")
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
	@PutMapping(path="/updatebook/{bookid}",consumes="application/json",produces="application/json")
	@ResponseBody
	public String update(@PathVariable int bookid, Book book) {
		service.updateBook(book);
		return "{msg: 'ok'}";
	}
	
	@GetMapping(path="/getbook/{bookid}",consumes="application/json",produces="application/json")
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
	@GetMapping(path="/getsomebook",consumes="application/json",produces="application/json")
	@ResponseBody
	public List<Book> getSomeBook(
			@RequestParam(name="s", defaultValue="10",required=false) int start,
			@RequestParam(name="o", defaultValue="0", required=false) int offset){
		return service.getSomeBook(start, offset);
	}
	
	/**
	 * 获得某个类别的十行书籍信息
	 * @param kind  类别
	 * @param offset 偏移量
	 * @return
	 */
	@GetMapping(path="/getkindbook",consumes="application/json",produces="application/json")
	@ResponseBody
	public List<Book> getKindBook(
			@RequestParam(name="k", required=true) String kind,
			@RequestParam(name="o", defaultValue="0", required=false) int offset){
		return service.getKindBook(kind, offset);
	}
}
