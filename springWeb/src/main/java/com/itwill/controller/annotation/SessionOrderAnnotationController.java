package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.itwill.dto.Order;

@SessionAttributes("order")
@Controller
public class SessionOrderAnnotationController {
	/*
	 -@Session 
	 * 
	 */
	@ModelAttribute("order")
	public Order setUpOrder() {
		// public @ModelAttribute Order setUpOrder() {}
		//return되는 order가 session에 꽂힘
		System.out.println("---> setUpOrder");
		return new Order();
	}
	
	@RequestMapping(value = "session_order_process1.do")
	public String session_order_process1() {
		
		return "session_order_process1";
	}
	/*
	 * @se
	 */
	@RequestMapping(value = "session_order_process2.do")
	public String order_process2(@ModelAttribute("order") Order order) {
		//실제 세션과 연관되지 않으면 modelattribute와 연관된 객체가 무조건 생성됨.
		// 근데 여기선 생성되면 안되니까 order를 선언해주고
		// 같은이름으로 ("order")를 해주면 됨
		
		return "session_order_process2";
	}
	@RequestMapping(value = "session_order_process3.do")
	public String order_process3(@ModelAttribute("order") Order order) {
		
		return "session_order_process3";
	}
	@RequestMapping(value = "session_order_input_result.do")
	public String session_order_input_result(@ModelAttribute("order") Order order) {
		
		return "session_order_input_result";
	}
	
	@RequestMapping(value = "session_order_create.do")
	public String session_order_create(@SessionAttribute("order") Order order, SessionStatus sessionStatus) {
		
		System.out.println(">>>> 데이타베이스에주문 insert[orderService.create(order)]"+order);
		
		sessionStatus.setComplete(); //order삭제작업 (session.removeAttribute("order") 기능
		
		return "session_order_create";
	}
	
	
}