package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
public class ResponseController {
	@RequestMapping("/response_view_name.do")
	public String response_view_name() {
		return "forward:/WEB-INF/views/response_view_name.jsp";
	}
	
	
	@RequestMapping("/response_view_object.do")
	public View response_view_object() {
		InternalResourceView internalResourceView = new InternalResourceView();
		//internalResourceView.setUrl("/WEB-INF/views/response_view_object.jsp");
		internalResourceView.setUrl("/WEB-INF/views/response_view_name.jsp");
		return internalResourceView;
	}
	
	/**** xml 출력 view [XML view] ****/
	
	@RequestMapping("/response_xml_view_object.do")
	public View response_xml_view_object() {
		XMLView xmlView = new XMLView();
		return xmlView;
		
	}
	
}
