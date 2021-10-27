package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itwill.dto.Order;

@SessionAttributes("order")
@Controller
public class SessionOrderAnnotationController {
	
	
	@RequestMapping(value = "session_order_process1.do")
	public String session_order_process1() {
		
		return "session_order_process1";
	}
	@RequestMapping(value = "session_order_process2.do")
	public String order_process2() {
		return "session_order_process2";
	}
	@RequestMapping(value = "session_order_process3.do")
	public String order_process3() {
		
		return "session_order_process3";
	}
	@RequestMapping(value = "session_order_input_result.do")
	public String session_order_input_result() {
		
		return "session_order_input_result";
	}
	
	@RequestMapping(value = "session_order_create.do")
	public String session_order_create() {
		
		System.out.println(">>>> 데이타베이스에주문 insert[orderService.create(order)]");
		
		return "session_order_create";
	}
	
	
}