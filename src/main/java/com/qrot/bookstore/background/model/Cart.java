package com.qrot.bookstore.background.model;

/**
 * 购物车实体类
 * 
 * @author TanZhiHua 2018年8月4日09点01分
 */
public class Cart {

	int userId;
	int bookId;
	int quantity;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
