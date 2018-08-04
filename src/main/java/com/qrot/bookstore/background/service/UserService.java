package com.qrot.bookstore.background.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrot.bookstore.background.mapper.UserMapper;
import com.qrot.bookstore.background.model.User;

/**
 * 业务逻辑：依赖数据访问操作，自动注入各个实体类的 Mapper
 * @author TanZhiHua
 *2018年8月4日09点28分
 */
@Service
public class UserService {
	
	@Autowired
	UserMapper usermapper;
	
	public User loadUser(String name) {
		return usermapper.load(name);
	}

}
