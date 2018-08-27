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
<<<<<<< HEAD
	@Select("select * from user where user_name=#{name}")
=======
	@Select("select * from v_show_all_user where user_name=#{name}")
>>>>>>> 31aa3d9c6ed70a098dc076a14b8ce64096521d38
	@Results(value = { 
			@Result(column = "user_id", property = "id"), 
			@Result(column = "user_name", property = "name"),
			@Result(column = "user_password", property = "password"),})
<<<<<<< HEAD
	User login(@Param("name") String name);
=======
	User login(
			@Param("name") String name);
>>>>>>> 31aa3d9c6ed70a098dc076a14b8ce64096521d38
}
