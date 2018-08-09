package com.qrot.bookstore.background.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrot.bookstore.background.mapper.OrdersMapper;
import com.qrot.bookstore.background.model.Orders;

/**
 * 关于订单的业务逻辑：依赖数据访问操作
 * @author 15295
 *
 */
@Service
public class BackOrderService {

	@Autowired
	OrdersMapper ordersMapper;
	
	/**
	 * 更新订单状态
	 * @param order
	 */
	public void updateOrder(Orders order) {
		ordersMapper.updateOrder(order);
	}
}
