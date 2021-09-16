package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestMappingParameterController {
	@RequestMapping("/parameter_guest_write_form.do")
	public String parameter_guest_write_form() {
		
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping(value="/model_attribute_guest_write_action.do", method = RequestMethod.POST)
	public String model_attribute_guest_write_action(@ModelAttribute("guest") Guest guest) {
		/*
		 * 1. Guest guest = Guest();
		 * 2. String guest_name = request.getParameter("guest_name");
			  String guest_email = request.getParameter("guest_email");
			  String guest_homepage = request.getParameter("guest_homepage");
			  String guest_title = request.getParameter("guest_title");
			  String guest_content = request.getParameter("guest_content");
		   3. guest.setGuest_name(guest_name) --> setProperties
		      guest.setGuest_email(guest_email)
		      guest.setGuest_homepage(guest_hompage)
		      guest.setGuest_title(guest_title)
		      guest.setGuest_content(guest_content)
		   4. request.setAttribute("guest", guest);
		 */
		
		/*
		   1. 인자로 선언된 DTO객체 [Guest]생성(기본생성자)
		   2. 파라메타의 모든 객체 받기
		   3. 받은 파라메타 데이타를 파라메타 이름과 일치하는 Guest객체의 속성메쏘드(setter method)호출해서 대입
		   4. Guest클래스이름 첫글자를 소문자로 변경한 이름(guest)으로 request객체에 속성(attribute)등록 
		      request.setAttribute("guest",guest);
		 */
		
		System.out.println("### @ModelAttribute ###");
		System.out.println("### guest "+guest);
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	
	
	
	
	@RequestMapping(value="/parameter_guest_write_action.do",method=RequestMethod.POST)
	public String parameter_guest_write_action( @RequestParam("guest_name") String name,
												@RequestParam("guest_title") String guest_title,
												@RequestParam("guest_email") String guest_email,
												@RequestParam String guest_homepage,
												@RequestParam String guest_content) {
		/*
		 << @RequestParam >>
			String guest_name = request.getParameter("guest_name");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
		 */
		Guest guest=new Guest(0, name, null, guest_email, guest_homepage, guest_title, guest_content);
		/*
		 * GuestService메쏘드호출
		 */
		System.out.println("### @RequestParam ###");
		System.out.println("### guest:"+guest);
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
}

