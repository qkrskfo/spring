package com.itwill.controller.annotation;

import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		//return "forward:/WEB-INF/views/jstl_fmt_i18n.jsp";
		return "jstl_fmt_i18n";
	}
	/************Spring JSP에서 국제화*******************
	1. application-config.xml에 MessageSource빈설정
	 <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
  		<property name="basenames" value="messages/guest,messages/messages,messages/user"/>
  	 </bean>
  	 *****************************************************/
	@RequestMapping("/spring_customtag_spel_i18n.do")
	public String spring_customtag_spel_i18n() {
		return "spring_customtag_spel_i18n";
	}
	
	
	/************Spring Controller에서 국제화*******************
	1. application-config.xml에 MessageSource빈설정
	 <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
   		<property name="basenames" value="messages/guest,messages/messages,messages/user"/>
   	 </bean>
   	 
   	 2. Controller객체 에서 MessageSource객체 injection
   	 
   	 3. Controller객체메쏘드에서 MessageSource객체 사용
   	 
   	 	String msg = messageSource.getMessage("user.existed.exception",
											null,
											requestLocale);
   	 
   *************************************************************/
	
	@RequestMapping("/spring_controller_i18n.do")
	public String spring_customtag_i18n(Locale requestLocale,Model model) {
		/*
		/*
		<< messags_ko.properties >>
		user.existed.exception = {0}는 존재하는 아이디 입니다.
		user.notfound.exception = {0}는 존재하지 않는 아이디입니다.
		
		<< messags_ko.properties >>
		user.existed.exception = {0} User ID already exist.
		user.notfound.exception = {0} User ID don't exist.
		 */
		
		String msg = messageSource.getMessage("user.existed.exception",
											new Object[] {"guard"},
											requestLocale);
		
		model.addAttribute("user_existed_exception_controller_msg", msg);
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
