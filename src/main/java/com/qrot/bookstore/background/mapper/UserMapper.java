package com.qrot.bookstore.background.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qrot.bookstore.background.model.User;

@Mapper
public interface UserMapper {

	/**
	 * 管理员登录
	 * 
	 * @param name
	 * @return
	 */
	@Select("select * from v_show_all_user where user_name=#{name}")
	@Results(value = { 
			@Result(column = "user_id", property = "id"), 
			@Result(column = "user_name", property = "name"),
			@Result(column = "user_password", property = "password"),})
	User login(
			@Param("name") String name);
}
