package com.qrot.bookstore.background.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qrot.bookstore.background.model.Orders;

/**
 * orderMapper
 * @author 15295
 *
 */
@Mapper
public interface OrdersMapper {

	/**
	 * 查询某个订单的信息
	 * @param orderID
	 * @return
	 */
	@Select("select * from orders where order_id=#{orderID}")
	@Results(value= {
			@Result(column="order_id",property="orderID"),
	})
	Orders loadOrder(int orderID);
	
	/**
	 * 修改订单状态
	 * @param order
	 */
	@Update("update orders set order_state=#{state} where order_id=#{id}")
	@Results(value= {
			@Result(column="order_state",property="orderState"),
			@Result(column="order_id",property="orderID"),
	})
	void updateOrder(Orders order);
}
