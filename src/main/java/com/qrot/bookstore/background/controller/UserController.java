package com.qrot.bookstore.background.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrot.bookstore.background.model.User;
import com.qrot.bookstore.background.service.BackUserService;

/**
 * 控制器
 * @author 15295
 *
 */
@RestController
@RequestMapping("/api/1")
@CrossOrigin
public class UserController {
	
	@Autowired
	BackUserService service;

	@GetMapping("/login")
	@ResponseBody
	public String login(
			@RequestParam(name="n") String name,
			@RequestParam(name="p") String password) {
		String msg;
		
		if(!("admin".equals(name))) {
			msg = "用户名错误！";
<<<<<<< HEAD
=======
			
>>>>>>> 31aa3d9c6ed70a098dc076a14b8ce64096521d38
		}else {
			User user = service.login(name);
			if(user.getPassword().equals(password)) {
				msg="OK";
			}else {
				msg="密码错误";
			}
<<<<<<< HEAD
		}	
=======
		}
		
>>>>>>> 31aa3d9c6ed70a098dc076a14b8ce64096521d38
		return msg;
	}
}
