package com.qrot.bookstore.background.model;

/**
 * 用户实体类
 * 
 * @author TanZhiHua 2018年8月4日09点02分
 */
public class User {

	int id;
	String name;
	String password;
	String userHead;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

}
