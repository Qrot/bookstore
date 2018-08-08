package com.qrot.bookstore.background.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import com.qrot.bookstore.background.model.Book;
/**
 * Mapper
 * 
 * @author 15295
 *
 */
@Mapper
public interface BookMapper {

	/**
	 * 增加书籍的基本信息
	 * @param book
	 */
	@Insert("insert into book_info(book_isbn,book_name,book_author,book_publish,book_kind,book_summary,book_publtime,book_cover) "
			+ "values(#{isbn},#{bookname},#{author},#{publish},#{kind},#{summary},#{publtime},#{cover})")
	void addBookInfo(Book book);
	
	/**
	 * 增加书籍变动信息
	 * @param book
	 */
	@Insert("insert into book(book_id,book_price,bok_storage,book_volume,book_score,book_delete) "
			+ "values(LAST_INSERT_ID(),#{price},#{storage},#{volume},#{score},#{delete})")
	void addBook(Book book);
	
	/**
	 * 书籍下架
	 * @param bookid
	 */
	@Update("update book set book_delete = 1 where book_id=#{bookid}")
	void removeBook(int bookid);
	
	/**
	 * 书籍上架
	 * @param bookid
	 */
	@Update("update book set book_delete = 0 where book_id=#{bookid}")
	void recoverBook(int bookid);
	
	/**
	 * 得到指定的那本书的全部信息
	 * @param bookid
	 * @return
	 */
	@Select("select * from v_book where book_id =#{bookid}")
	@Results(value = { 
			@Result(column = "book_id", property = "id"),  
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "bookname"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_publtime", property = "publtime"),
			@Result(column = "book_cover", property = "cover"), 
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"),})
	Book getOneBook(int bookid);
	
	/**
	 * 显示指定行数的全部书籍信息
	 * @param kind
	 * @param offset
	 * @return
	 */
	@Select("select * from v_book limit #{start} offset #{offset}")
	@Results(value = { 
			@Result(column = "book_id", property = "bookid"),  
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "bookname"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_publtime", property = "publtime"),
			@Result(column = "book_cover", property = "cover"), 
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"),})
	List<Book> getSomeBook(int start, int offset);
	
	/**
	 * 分类显示书籍
	 * @param kind
	 * @param offset
	 * @return
	 */
	@Select("select * from v_book where book_kind=#{kind} limit 10 offset #{offset}")
	@Results(value = { 
			@Result(column = "book_id", property = "bookid"), 
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "bookname"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_publtime", property = "publtime"),
			@Result(column = "book_cover", property = "cover"),
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"),  })
	List<Book> getKindBook (String kind, int offset);
	
	/**
	 * 更新书籍信息
	 * @param book
	 */
	@Update("update book set book_price=#{price},book_storage=#{storage},book_volume=#{volume},book_score=#{score} where book_id=#{bookid}")
	@Results(value = { 
			@Result(column = "book_id", property = "bookid"),
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),  })
	void update(Book book);
}
