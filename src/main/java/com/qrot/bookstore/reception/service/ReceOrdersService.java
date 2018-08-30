package com.qrot.bookstore.reception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qrot.bookstore.reception.mapper.ReceOrdersMapper;
import com.qrot.bookstore.reception.model.Item;
import com.qrot.bookstore.reception.model.Orders;

/**
 * 
 * @author TanZhiHua 2018年8月11日09点26分
 */
@Service
public class ReceOrdersService {
	
	@Autowired
	ReceOrdersMapper ordersMapper;

	/**
	 * 生成订单
	 * @param order
	 */
	@Transactional
	public void subOrder(Orders order) {
		ordersMapper.subOrder(order);
		
		// 循环插入订单项
		for (Item item : order.getItemList()) {
			ordersMapper.createItem(item);
			ordersMapper.updateBookVolume(item);
		}
		
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore
=======
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore
=======
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore
=======
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore
=======
=======
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
=======
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
=======
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
	
	/**
	 * 删除订单
	 * @param orderId
	 */
	@Transactional
	public void deleteOrder(int orderId) {
		ordersMapper.deleteOrder(orderId);
	}
	
	/**
	 * 查询用户订单
	 * @param userId
	 * @return
	 */
	public List<Orders> selectUserOrder(int userId){
		return ordersMapper.selectUserOrder(userId);
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
=======
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore
=======
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore
=======
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
=======
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"
=======
>>>>>>> parent of 71117d8... Revert "Merge branch 'master' of https://github.com/Qrot/bookstore"

	/**
	 * 删除订单
	 * @param orderId
	 */
	@Transactional
	public void deleteOrder(int orderId) {
		ordersMapper.deleteOrder(orderId);
	}
	
	/**
	 * 查询用户订单
	 * @param userId
	 * @return
	 */
	public List<Orders> selectUserOrder(int userId){
		return ordersMapper.selectUserOrder(userId);
	}
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore

}
