package com.itwill.controller.annotation;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;


/*
 * Spring MVC에서 출력을 담당하는 객체
 */
public class XMLView extends AbstractView {

	@Override
	public void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' encoding='UTF-8' ?>");
		out.println("<friends>");
		out.println("</friends>");
		
	}

}
