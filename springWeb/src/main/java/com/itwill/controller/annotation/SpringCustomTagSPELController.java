package com.itwill.controller.annotation;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.Guest;

@Controller
public class SpringCustomTagSPELController {
	
	private MessageSource messageSource;
	
	@Autowired
	@Qualifier("messageSource")
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@RequestMapping("/jstl_fmt_i18n.do")
	public String jstl_fmt_i18n() {
		return "jstl_fmt_i18n";
	}
	
	/*** SpringCustomTagSPELController 에서 국제화 해야함 ***/
	//버튼이름 취소/cancle, 등록/submit 같은거
	@RequestMapping("/spring_customtag_i18n.do")
	public String spring_customtag_i18n() {
		
		return "spring_customtag_spel_i18n";
	}
	
	@RequestMapping("/spring_customtag_spel.do")
	public String spring_customtag_spel(HttpServletRequest request) {
		request.setAttribute("price0", 345345435);
		request.setAttribute("name0", "kim eun hi");
		
		request.setAttribute("price1", 231151);
		request.setAttribute("name1", "LEE HYO LEE");
		request.setAttribute("married1", true);
		
		request.setAttribute("price2", 12345456);
		request.setAttribute("name2", "김태희");
		request.setAttribute("married2", true);
		
		request.setAttribute("guest", 
					new Guest(1, "김수미", new Date().toLocaleString(),
							"guard@naver.com", "http://www.google.com",
							"오늘은목요일", "Spring EL에대해 공부합니다."));
		return "spring_customtag_spel";
	}
}
