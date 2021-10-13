package com.itwill.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping(value = "02.ajaxRequest1")
	public String ajaxRequest() {
		//return "forward:/WEB-INF/views/02.ajaxRequest.jsp";
		return "02.ajaxRequest";
	}
	
	@RequestMapping(value="02.ajaxRequest2", produces="text/plain;charset=utf-8")
	@ResponseBody
	/*
	 * << @ResponseBody >>
	 * - ViewResolver --> View를 사용하지 않는다
	 * - MessageConverter(text, xml, json)가 클라이언트로 응답한다.
	 */
	public String ajaxRequest(@RequestParam(required=true, defaultValue="") String id) {
		String msg="";
		if(id.startsWith("guard")){
			msg="사용가능";
		}else{
			msg="사용불가능";
		}
		return msg;
	}
	
	
	@RequestMapping(value = "03.ajaxRequestGETPOST1")
	public String ajaxRequestGETPOST() {
		return "03.ajaxRequestGETPOST";
	}
	
	@RequestMapping(value = "03.ajaxRequestGETPOST2", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String ajaxRequestGETPOST(@RequestParam(required=true, defaultValue="") String id) {
		String msg="";
		if(id.startsWith("guard")){
			msg="사용가능";
		}else{
			msg="사용불가능";
		}
		return msg;
	}
}