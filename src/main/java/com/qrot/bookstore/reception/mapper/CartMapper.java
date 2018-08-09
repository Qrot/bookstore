package com.qrot.bookstore.reception.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qrot.bookstore.reception.model.Cart;

/**
 * 
 * @author TanZhiHua
 *2018年8月6日08点39分
 */
@Mapper
public interface CartMapper {
	
	/**
	 * 显示所有购物车信息
	 * @return
	 */
	@Select("select * from v_show_all_cart")
	@Results(value = { 
			@Result(column = "user_id", property = "userId"), 
			@Result(column = "book_id", property = "bookId"),
			@Result(column = "cart_quantity", property = "quantity"),
			@Result(column = "book_name", property = "bookName"),
			@Result(column = "book_cover", property = "bookCover"), 
	})
	List<Cart> show();
	
	/**
	 * 查询某个用户购物车
	 * @param id
	 * @return
	 */
	@Select("select * from v_show_all_cart where user_id=#{id}")
	@Results(value = { 
			@Result(column = "user_id", property = "userId"), 
			@Result(column = "book_id", property = "bookId"),
			@Result(column = "cart_quantity", property = "quantity"),
			@Result(column = "book_name", property = "bookName"),
			@Result(column = "book_cover", property = "bookCover"), 
	})
	List<Cart> select(int id);

}
