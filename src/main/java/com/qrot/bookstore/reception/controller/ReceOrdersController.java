package com.qrot.bookstore.reception.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qrot.bookstore.reception.model.Orders;
import com.qrot.bookstore.reception.service.ReceOrdersService;

/**
 * 
 * @author TanZhiHua 2018年8月11日09点26分
 */
@Controller
@RequestMapping("/orders")
public class ReceOrdersController {

	@Autowired
	ReceOrdersService ordersService;

	@PostMapping("/create")
	@ResponseBody
	public void create(@RequestBody Orders order) {

		ordersService.subOrder(order);

	}

}