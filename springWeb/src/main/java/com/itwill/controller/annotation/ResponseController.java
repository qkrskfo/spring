package com.itwill.controller.annotation;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ResponseController {
	/* #### View 객체 반환 ### */
	
	/*
	 * forwading view객체반환
	 */
	@RequestMapping("/response_view_object.do")
	public View response_view_object() {
		InternalResourceView internalResourceView = new InternalResourceView();
		//internalResourceView.setUrl("/WEB-INF/views/response_view_object.jsp");
		internalResourceView.setUrl("/WEB-INF/views/response_view_name.jsp");
		/*
		 * 1.InternalResourceView 객체(URL:/WEB-INF/views/response_view_object.jsp)반환
		 * 2.URL--> /WEB-INF/views/response_view_object.jsp forward
		 */
		return internalResourceView; // 이걸 누가받아? dispatcher servlet이 받아
		// 받아서 renderMergedOutputModel 메소드를 호출해준데
	}

	/*
	 * forwarding view name(String)반환
	 */
	@RequestMapping("/response_view_name.do")
	public String response_view_name() {
		/* 
		  0 . view name(String)
		  1 . InternalResourceViewResolver 객체에 view name을 넘겨준다
		  2 . InternalResourceView 객체(URL:/WEB-INF/views/response_view_name.jsp)를 반환
		  3 . URL--> /WEB-INF/views/response_view_name.jsp forward	
		*/
		return "forward:/WEB-INF/views/response_view_name.jsp";
	}
	
	
	/*
	 * redirect view객체반환
	 */
	@RequestMapping("/response_redirect_view_object.do")
	public View response_redirect_view_object() {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("response_redirect_view_object.jsp");
		/*
		 * 1.RedirectView 객체(URL:response_redirect_view_object.jsp)반환
		 * 2.URL--> response_redirect_view_object.jsp redirect응답
		 */
		return redirectView;
	}
	
	/*
	 * xml출력 view객체반환
	 */
	/**** xml 출력 view [XML view] ****/
	@RequestMapping("/response_xml_view_object.do")
	public View response_xml_view_object(Model model) {
		ArrayList<String> friendList = new ArrayList<String>();
		friendList.add("김수미");
		friendList.add("김우미");
		friendList.add("김미미");
		friendList.add("김양미");
		friendList.add("김가미");
		model.addAttribute("friendList", friendList);
		XMLView xmlView = new XMLView();
		return xmlView;
		
	}
	
}
