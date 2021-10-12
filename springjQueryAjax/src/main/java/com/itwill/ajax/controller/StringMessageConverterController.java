package com.itwill.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StringMessageConverterController {
	@RequestMapping(value="/response_string1.do", produces="text/plain;charset=utf-8")
	public @ResponseBody String responseString1() { //responseBody는 여기에 붙여도 됨
		return "hello string ajax[한글]";
	}
	
	@RequestMapping(value="/response_string2.do", produces="text/html;charset=utf-8")
	@ResponseBody 
	public String responseString2() { //responseBody는 여기에 붙여도 됨
		return "<h2>hello string ajax[한글]</h2><hr>";
	}
}
