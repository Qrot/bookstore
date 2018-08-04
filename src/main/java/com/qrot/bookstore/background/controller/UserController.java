package com.qrot.bookstore.background.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrot.bookstore.background.model.User;
import com.qrot.bookstore.background.service.UserService;

/**
 * 控制器依赖业务逻辑
 * 
 * @author TanZhiHua 2018年8月4日09点25分
 */

@Controller
// 控制器的 URL
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	@ResponseBody
	public User get(@PathVariable String name, @PathVariable String password) {
//		String msg;
		User user = userService.loadUser(name);
		if(user == null) {
//			msg = "用户名不存在";
//			return msg;
			return null;
		}
		
		if (user.getPassword().equals(password)) {
//			msg = "登陆成功";
//			return msg;
			return user;
		}
//		return "用户名或密码错误";
		return null;
	}

}
