package com.qrot.bookstore.reception.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;

import com.qrot.bookstore.reception.model.Item;
import com.qrot.bookstore.reception.model.Orders;

/**
 * 
 * @author TanZhiHua
 *2018年8月11日09点26分
 */
@Mapper
public interface ReceOrdersMapper {
	
	/**
	 * 向订单表添加用户订单
	 */
	@Insert("insert into orders(order_total,user_id,order_state,order_name,order_address,order_phone,order_time) "
			+ "values (#{total}, #{userId}, #{state}, #{name}, #{address}, #{phone}, #{time})")
	void subOrder(Orders order);
	
	/**
	 * 向订单项表添加书籍数据
	 * @param item
	 */
	@Insert("insert into item values ((last_insert_id()), #{bookId}, #{quantity}, #{price})")
	void createItem(Item item);
	
	/**
	 * 书籍销量增加
	 * @param item
	 */
	@Update("update book set book_volume=(book_volume+(#{quantity})) where book_id=#{bookId}")
	void updateBookVolume(Item item);

}
