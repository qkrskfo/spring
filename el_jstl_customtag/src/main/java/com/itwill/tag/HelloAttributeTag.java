package com.itwill.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloAttributeTag extends TagSupport {
	
	private String irum;
	
	public HelloAttributeTag() {
		System.out.println("1. HelloAttributeTag() 기본생성자");
	}
	
	public void setIrum(String irum) {
		System.out.println("2. HelloAtrributeTag.setIrum("+irum+")");
		this.irum = irum;
	}
	
	@Override
	public int doStartTag() throws JspException {
		String msg = "";
		if(irum==null) {
			irum = "손님";
			msg = irum+" 안녕하세요<br>";
		} else if(irum.equals("김경호")) {
				msg="잘생긴" +irum+" 님 안녕하세요. <br>";
		} else {
				msg=irum+" 님 안녕하세요. <br>";
		}
		
		
		try {
			pageContext.getOut().println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
	
}
