package com.qrot.bookstore.background.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrot.bookstore.background.mapper.UserMapper;
import com.qrot.bookstore.background.model.User;

/**
 * 业务逻辑
 * @author 15295
 *
 */
@Service
public class BackUserService {
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 用户登录
	 * @param name
	 * @return
	 */
	public User login(String name) {
		return userMapper.login(name);
	}
}
