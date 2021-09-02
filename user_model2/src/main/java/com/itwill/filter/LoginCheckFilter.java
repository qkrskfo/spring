package com.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 모든 요청을 다 받으면 안됨. userMain같은건 로그인 체크를 할 필요가 없잖앙
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String sUserId = (String)req.getSession().getAttribute("sUserId");
		if(sUserId==null) {
			resp.sendRedirect("user_main.do");
			return;
		}
		
		chain.doFilter(request, response);
		
	}
	
}
