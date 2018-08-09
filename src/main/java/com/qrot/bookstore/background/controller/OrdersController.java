package com.qrot.bookstore.background.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrot.bookstore.background.model.Orders;
import com.qrot.bookstore.background.service.BackOrderService;

@RequestMapping("/api/1")
@RestController
public class OrdersController {

	@Autowired
	BackOrderService service;
	
	/**
	 * 修改订单状态
	 * @param order
	 * @return
	 */
	@PutMapping(path="/updateOrder",consumes="application/json",produces="application/json")
	@ResponseBody
	public String updateOrder(Orders order) {
		service.updateOrder(order);
		return "{msg: 'ok'}";
	}
}
