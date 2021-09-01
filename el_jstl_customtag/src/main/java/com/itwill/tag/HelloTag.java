package com.itwill.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport {

	public HelloTag() {
		System.out.println("1. HelloTag() 기본생성자");
	}
	
	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloTag.doStartTag() [시작태그를 만났습니다.]");
		try {
			JspWriter out = pageContext.getOut();
			out.println("GUEST님 안녕하세요.<br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		System.out.println("HelloTag.doEndTag() [끝태그를 만났습니다.]");
		return super.doEndTag();
	}
	
	
}
