package com.qrot.bookstore.background.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.qrot.bookstore.background.model.Book;

@Mapper
public interface BookMapper {

	//增加书籍的基本信息
	@Insert("insert into book_info(book_isbn,book_name,book_author,book_publish,book_kind,book_summary,book_publtime,book_cover) "
			+ "values(#{isbn},#{bookname},#{author},#{publish},#{kind},#{summary},#{publtime},#{cover})")
	void addBookInfo(Book book);
	
	//增加书籍变动信息
	@Insert("insert into book(book_id,book_price,bok_storage,book_volume,book_score,book_delete) "
			+ "values(LAST_INSERT_ID(),#{price},#{storage},#{volume},#{score},#{delete})")
	void addBook(Book book);
	
	
}
