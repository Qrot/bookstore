package com.qrot.bookstore.reception.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qrot.bookstore.reception.model.Book;
import com.qrot.bookstore.reception.model.Comment;

/**
 * 
 * @author TanZhiHua 2018年8月6日10点34分
 */
@Mapper
public interface ReceBookMapper {

	/**
	 * 显示所有书籍信息
	 * 
	 * @return
	 */
	@Select("select * from v_show_all_book")
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
			@Result(column = "book_cover", property = "cover"), 
	})
	List<Book> show();
	
	/**
	 * 根据书籍 id 查询书籍详细信息
	 * @param id
	 * @return
	 */
	@Select("select * from v_show_all_book where book_id=#{id}")
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
			@Result(column = "book_cover", property = "cover"), 
			@Result(
					property="commentList",
					column="book_id",
					javaType=List.class,
					many=@Many(select="findCommentById")
					)
	})
	Book showBookDetailInfo(int bookId);
	
	/**
	 * 获得特定书籍的的所有评论
	 * @param id
	 * @return
	 */
	@Select("select * from comment where book_id=#{id} order by comm_time desc")
	@Results(value = { 
			@Result(column = "comm_id", property = "commId"), 
			@Result(column = "comm_score", property = "score"),
			@Result(column = "comm_content", property = "content"),
			@Result(column = "comm_time", property = "time"), 
			@Result(column = "book_id", property = "bookId"),
			@Result(column = "order_id", property = "orderId"), 
			@Result(column = "user_id", property = "userId"),
	})
	List<Comment> findCommentById(int id);
	
	/**
	 * 模糊查询搜索书籍
	 * @return
	 */
	@Select("select * from v_show_all_book where book_price regexp #{price} "
			+ "or book_score regexp #{score} or book_name regexp #{name} "
			+ "or book_author regexp #{author} or book_publish regexp #{publish} "
			+ "or book_kind regexp #{kind} or book_publtime regexp #{publTime}")
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
			@Result(column = "book_publtime", property = "publTime"),
			@Result(column = "book_cover", property = "cover"), 
	})
	List<Book> selectBook(
			@Param("price") String price,
			@Param("score") String score,
			@Param("name") String name,
			@Param("author") String author,
			@Param("publish") String publish,
			@Param("kind") String kind,
			@Param("publTime") String publTime
			);

	/**
	 * 按时间排序
	 * 
	 * @return
	 */
	@Select("select * from v_show_all_book order by book_publtime desc limit 10 offset 0")
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
			@Result(column = "book_cover", property = "cover"),
	})
	List<Book> timeSelectSort();

	/**
	 * 按销量排序
	 * 
	 * @return
	 */
	@Select("select * from v_show_all_book order by book_volume desc limit 10 offset 0;")
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
			@Result(column = "book_cover", property = "cover"), 
	})
	List<Book> volumeSelectSort();

	/**
	 * 按评分排序
	 * 
	 * @return
	 */
	@Select("select * from v_show_all_book order by book_score desc limit 10 offset 0")
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
			@Result(column = "book_cover", property = "cover"), 
	})
	List<Book> scoreSelectSort();
	
	/**
	 * 分类显示书籍
	 * @return
	 */
	@Select("select * from v_show_all_book where book_kind=#{kind} limit 10 offset #{offset}")
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
			@Result(column = "book_cover", property = "cover"), 
	})
	List<Book> kindShow(
			@Param("kind") String kind,
			@Param("offset") int offset);

}
