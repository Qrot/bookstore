package com.qrot.bookstore.background.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrot.bookstore.background.model.User;

/**
 * 控制器
 * @author 15295
 *
 */
@RestController
@RequestMapping("/api/1")
@CrossOrigin
public class UserController {
	
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody User u) {
		if("admin".equals(u.getName())) {
			if("123456".equals(u.getPassword())) {
				return "OK";
			}
			else
				return "密码错误！";
		}
		else
			return "无此用户！";
	}
	
}
