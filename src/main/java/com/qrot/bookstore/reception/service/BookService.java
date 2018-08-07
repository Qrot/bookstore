package com.qrot.bookstore.reception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrot.bookstore.reception.mapper.BookMapper;
import com.qrot.bookstore.reception.model.Book;

/**
 * 
 * @author TanZhiHua 2018年8月6日10点51分
 */
@Service
public class BookService {

	@Autowired
	BookMapper bookMapper;

	/**
	 * 显示所有书籍信息
	 * @return
	 */
	public List<Book> show() {
		return bookMapper.show();
	}
	
	/**
	 * 按时间排序
	 * @return
	 */
	public List<Book> timeSelectSort(){
		return bookMapper.timeSelectSort();
	}
	
	/**
	 * 按销量排序
	 * @return
	 */
	public List<Book> volumeSelectSort(){
		return bookMapper.volumeSelectSort();
	}
	
	/**
	 * 按评分排序
	 * @return
	 */
	public List<Book> scoreSelectSort(){
		return bookMapper.scoreSelectSort();
	}

	/**
	 * 分类显示
	 * @param kind
	 * @param offset
	 * @return
	 */
	public List<Book> kindShow(String kind, int offset){
		return bookMapper.kindShow(kind, offset);
	}

}
