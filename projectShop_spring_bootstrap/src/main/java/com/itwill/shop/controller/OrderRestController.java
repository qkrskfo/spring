package com.itwill.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.user.UserService;


@RestController
public class OrderRestController {
	@Autowired
	private OrderService orderService;


	@LoginCheck
	@RequestMapping(value = "order_detail_rest",produces = "application/json;charset=UTF-8")
	public Order order_detail(@RequestParam int o_no, HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		Order order = orderService.detail(sUserId, o_no);
		return order;
	}
	
}
