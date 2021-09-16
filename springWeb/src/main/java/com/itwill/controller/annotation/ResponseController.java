package com.itwill.controller.annotation;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
