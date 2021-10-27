package com.itwill.controller.annotation;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.itwill.dto.Order;

//@Controller
public class SessionOrderController {
	
	@RequestMapping(value = "session_order_process1.do")
	public String session_order_process1(HttpSession session) {
		Order order = (Order)session.getAttribute("order");
		if(order==null) {
			session.setAttribute("order", new Order());
		}
		return "session_order_process1";
	}
	@RequestMapping(value = "session_order_process2.do")
	public String order_process2(HttpSession session, @RequestParam String name) {
		Order order = (Order)session.getAttribute("order");
		order.setName(name);
		return "session_order_process2";
	}
	@RequestMapping(value = "session_order_process3.do")
	public String order_process3(HttpSession session, @RequestParam String cardNo) {
		Order order = (Order)session.getAttribute("order");
		order.setCardNo(cardNo);
		return "session_order_process3";
	}
	
	@RequestMapping(value = "session_order_input_result.do")
	public String session_order_input_result(HttpSession session, @RequestParam String address) {
		Order order = (Order)session.getAttribute("order");
		order.setAddress(address);
		return "session_order_input_result";
	}
	
	@RequestMapping(value = "session_order_create.do")
	public String session_order_create(HttpSession session) {
		Order order = (Order)session.getAttribute("order");
		System.out.println(">>>> 데이타베이스에주문 insert[orderService.create(order)]"+order);
		session.removeAttribute("order");
		return "session_order_create";
	}
	
	
}
