package com.qrot.bookstore.reception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrot.bookstore.reception.mapper.ReceCartMapper;
import com.qrot.bookstore.reception.model.Cart;

/**
 * 
 * @author TanZhiHua
 *2018年8月6日08点42分
 */
@Service
public class ReceCartService {
	
	@Autowired
	ReceCartMapper cartMapper;
	
	/**
	 * 显示所有购物车信息
	 * @return
	 */
	public List<Cart> show(){
		return cartMapper.show();
	}
	
	/**
	 * 根据用户id查询用户购物车 
	 * @param id
	 * @return
	 */
	public List<Cart> select(int id) {
		return cartMapper.select(id);
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
	 * 添加购物车
	 * @param cart
	 * @return
	 */
	public Cart create(Cart cart) {
		return cartMapper.create(cart);
	}
	
	/**
	 * 修改购物车订单项
	 * @param cart
	 * @return
	 */
	public void update(Cart cart) {
		cartMapper.update(cart);
	}
	
	/**
	 * 删除单个购物车订单项
	 * @param cart
	 */
	public void delete(Cart cart) {
		cartMapper.delete(cart);
	}
	
	/**
	 * 清空该用户购物车
	 * @param userId
	 */
	public void empty(int userId) {
		cartMapper.empty(userId);
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
	 * 添加购物车
	 * @param cart
	 * @return
	 */
	public void create(Cart cart) {
		cartMapper.create(cart);
	}
	
	/**
	 * 修改购物车订单项
	 * @param cart
	 * @return
	 */
	public void update(Cart cart) {
		cartMapper.update(cart);
	}
	
	/**
	 * 删除单个购物车订单项
	 * @param cart
	 */
	public void delete(Cart cart) {
		cartMapper.delete(cart);
	}
	
	/**
	 * 清空该用户购物车
	 * @param userId
	 */
	public void empty(int userId) {
		cartMapper.empty(userId);
	}
>>>>>>> parent of fa38b89... Merge branch 'master' of https://github.com/Qrot/bookstore

}
