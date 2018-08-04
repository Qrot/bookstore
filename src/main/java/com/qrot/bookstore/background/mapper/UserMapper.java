package com.qrot.bookstore.background.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qrot.bookstore.background.model.User;

/**
 * 反射、注解：动态代理、cglib(字节码生成)
 * 
 * @author TanZhiHua 2018年8月4日09点47分
 */
@Mapper
public interface UserMapper {

	@Select("select * from user where user_name=#{name}")
	@Results(value = { 
			@Result(column = "user_id", property = "id"), 
			@Result(column = "user_name", property = "name"),
			@Result(column = "user_password", property = "password"),
			@Result(column = "user_head", property = "userHead"),
			@Result(column = "user_sex", property = "sex"), 
			@Result(column = "user_phone", property = "phone"), 
			@Result(column = "user_email", property = "email"), 
	})
	User load(String name);

}
