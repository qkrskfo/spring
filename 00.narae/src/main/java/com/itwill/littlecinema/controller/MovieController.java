package com.itwill.littlecinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

	@RequestMapping(value = {"/", "/main"})
	public String main() {
		return "main";
	}
	
}
