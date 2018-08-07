package com.qrot.bookstore.reception.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qrot.bookstore.reception.model.Book;

/**
 * 
 * @author TanZhiHua 2018年8月6日10点34分
 */
@Mapper
public interface BookMapper {

	/**
	 * 显示所有书籍信息
	 * 
	 * @return
	 */
	@Select("select * from v_showallbook")
	@Results(value = { 
			@Result(column = "book_id", property = "id"), 
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"), 
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "name"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_pubtime", property = "pubTime"),
			@Result(column = "book_cover", property = "cover"), })
	List<Book> show();

	/**
	 * 按时间排序
	 * 
	 * @return
	 */
	@Select("select * from v_showallbook order by book_publtime desc limit 10 offset 0")
	@Results(value = { 
			@Result(column = "book_id", property = "id"), 
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"), 
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "name"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_pubtime", property = "pubTime"),
			@Result(column = "book_cover", property = "cover"), })
	List<Book> timeSelectSort();

	/**
	 * 按销量排序
	 * 
	 * @return
	 */
	@Select("select * from v_showallbook order by book_volume desc limit 10 offset 0;")
	@Results(value = { 
			@Result(column = "book_id", property = "id"), 
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"), 
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "name"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_pubtime", property = "pubTime"),
			@Result(column = "book_cover", property = "cover"), })
	List<Book> volumeSelectSort();

	/**
	 * 按评分排序
	 * 
	 * @return
	 */
	@Select("select * from v_showallbook order by book_score desc limit 10 offset 0")
	@Results(value = { 
			@Result(column = "book_id", property = "id"), 
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"), 
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "name"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_pubtime", property = "pubTime"),
			@Result(column = "book_cover", property = "cover"), })
	List<Book> scoreSelectSort();
	
	/**
	 * 分类显示书籍
	 * @return
	 */
	@Select("select * from v_showallbook where book_kind=#{kind} limit 10 offset #{offset}")
	@Results(value = { 
			@Result(column = "book_id", property = "id"), 
			@Result(column = "book_price", property = "price"),
			@Result(column = "book_storage", property = "storage"),
			@Result(column = "book_volume", property = "volume"), 
			@Result(column = "book_score", property = "score"),
			@Result(column = "book_delete", property = "delete"), 
			@Result(column = "book_isbn", property = "isbn"),
			@Result(column = "book_name", property = "name"), 
			@Result(column = "book_author", property = "author"),
			@Result(column = "book_publish", property = "publish"), 
			@Result(column = "book_kind", property = "kind"),
			@Result(column = "book_summary", property = "summary"),
			@Result(column = "book_pubtime", property = "pubTime"),
			@Result(column = "book_cover", property = "cover"), })
	List<Book> kindShow(
			@Param("kind") String kind,
			@Param("offset") int offset);

}
