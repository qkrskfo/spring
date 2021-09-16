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
		  0 . Controller view name(String)반환
		  1 . DispatcherServlet객체는  InternalResourceViewResolver 객체에 view name을 넘겨준다.
		  	  (DispatcherServlet객체는  view name(String) 을가지고 View객체를 얻기위해서 ViewResolver객체에 View를 찾아달라고요청한다.)
		  2 . InternalResourceViewResolver 객체는 forward:로시작하는 view name이면  InternalResourceView 객체를 생성하고 view name을 url로 설정한후반환한다.
		      (url:/WEB-INF/views/response_view_name.jsp)를 반환
		  3 . DispatcherServlet객체는 반환받은 InternalResourceView 객체의 render 메쏘드호출한다: 	
			  (/WEB-INF/views/response_view_name.jsp 로 forward가이루어진다)	
			  
		  << mcv-config-view-resolver.xml >>
		  <!-- InternalResourceViewResolver -->
		  <bean id="myInternalResourceViewResolver" 
				class="org.springframework.web.servlet.view.InternalResourceViewResolver"/>	  
			  
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
	 * redirect view name(String)반환
	 */
	@RequestMapping("/response_redirect_view_name.do")
	public String response_redirect_view_name() {
		 /* 
		  0 . Controller view name(String)반환
		  1 . DispatcherServlet객체는  InternalResourceViewResolver 객체에 view name을 넘겨준다.
		  	  (DispatcherServlet객체는  view name(String) 을가지고 View객체를 얻기위해서 ViewResolver객체에 View를 찾아달라고요청한다.)
		  
		  2 . InternalResourceViewResolver 객체는 redirect:로 시작하는 view name이면 RedirectView 객체를 생성하고 view name을 url로 설정한후반환한다.
		      (url:response_redirect_view_name.jsp)를 반환
		  3 . DispatcherServlet객체는 반환받은 RedirectView 객체의 render 메쏘드호출한다: 	
			  (response_redirect_view_name.jsp 로 redirect가이루어진다)	
			  
		  << mcv-config-view-resolver.xml >>
		  <!-- InternalResourceViewResolver -->
		  <bean id="myInternalResourceViewResolver" 
				class="org.springframework.web.servlet.view.InternalResourceViewResolver"/>	  
			  
		*/
		
		return "redirect:response_redirect_view_name.jsp";
		//redirect니까 원래 do로 들어가는게 맞는데 우리 머리터질 것 같아서 선생님이 jsp로 되게 해줬데
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
