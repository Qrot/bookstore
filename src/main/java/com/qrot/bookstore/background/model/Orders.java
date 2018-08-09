package com.qrot.bookstore.background.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 订单实体类
 * @author 15295
 *
 */
public class Orders {

	private int orderID;
	private BigDecimal orderTotal;
	private int userID;
	private char orderState;
	private String orderName;
	private String orderAddress;
	private String orderPhone;
	private Timestamp orderTime;
	
	public Orders() {}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public char getOrderState() {
		return orderState;
	}

	public void setOrderState(char orderState) {
		this.orderState = orderState;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	
}
