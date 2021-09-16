package com.itwill.controller.annotation;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;


/*
 * Spring MVC에서 출력을 담당하는 객체
 */
public class XMLView extends AbstractView {

	@Override
	public void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("### DispatcherServlet이 View.renderMergedOutputModel() 호출한다.");
		
		ArrayList<String> friendList = (ArrayList<String>)model.get("friendList");
		/*** xml 출력 view [XML view] ***/
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' encoding='UTF-8' ?>");
		out.println("<friends>");
		for(String friend:friendList) {
			out.println("<friend>"+friend+"</friend>");
		}
		out.println("</friends>");
		
		/*********************forward**************************
		RequestDispatcher rd = request.getRequestDispatcher("xxx.jsp");
		rd.forward(request, response);
		********************************************************/
		/*********************redirect**************************
		response.sendRedirect("xxx.do");
		********************************************************/
		
	}

}
