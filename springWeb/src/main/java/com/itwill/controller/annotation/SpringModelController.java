package com.itwill.controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringModelController {
	//model은 데이터와 관련된 것
	
	@RequestMapping("/model_request.do")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트 데이터");
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	@RequestMapping("/model_map.do")
	public String map(Map map) {
		System.out.println("### map객체 --> "+map);
		return "forward:/WEB-INF/views/spring_model.jsp";
	}
	
	
}
