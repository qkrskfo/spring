package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringCustomTagSPELController {
	@RequestMapping("/jstl_fmt_i18n.do")
	public String jstl_fmt_i18n() {
		return "jstl_fmt_i18n";
	}
}
