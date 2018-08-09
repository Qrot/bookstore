package com.qrot.bookstore.background.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrot.bookstore.background.mapper.BookMapper;
import com.qrot.bookstore.background.model.Book;
@Service
public class BackgroundService {

	@Autowired
	BookMapper bookMapper;
	
	/**
	 * 新增书籍
	 * @param book
	 */
	public void addBook(Book book) {

		bookMapper.addBookInfo(book);
		bookMapper.addBook(book);
	}
	
	/**
	 * 书籍上架
	 * @param bookid
	 */
	public void recoverBook(int bookid) {
		bookMapper.recoverBook(bookid);
	}
	
	/**
	 * 书籍下架
	 * @param bookid
	 */
	public void removeBook(int bookid) {
		bookMapper.removeBook(bookid);
	}
	
	/**
	 * 修改某本书的变动信息
	 * @param book
	 */
	public void updateBook(Book book) {
		bookMapper.update(book);
	}
	
	/**
	 * 得到某一本书的信息信息
	 * @param bookid
	 * @return
	 */
	public Book getOneBook(int bookid) {
		return bookMapper.getOneBook(bookid);
	}
	
	/**
	 * 获得指定行的书籍信息
	 * 
	 * @param start
	 * @param offset
	 * @return
	 */
	public List<Book> getSomeBook(int start,int offset){
		return bookMapper.getSomeBook(start, offset);
	}
	
	/**
	 * 获得某个类别的十行书籍信息
	 * @param kind  类别
	 * @param offset 偏移量
	 * @return
	 */
	public List<Book> getKindBook(String kind,int offset){
		return bookMapper.getKindBook(kind, offset);
	}
	
}
