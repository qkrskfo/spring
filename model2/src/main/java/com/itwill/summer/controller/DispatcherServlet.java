package com.itwill.summer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.member.Member;
import com.itwill.member.MemberService;

/*
 * 클라이언트의 모든요청(*.do)을 받는 서블릿(Controller)
 */

public class DispatcherServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		<<요청 URL>>
		/member_main.do  	---forward---> /WEB-INF/views/member_main.jsp
		/member_list.do  	---forward---> /WEB-INF/views/member_list.jsp
		/member_detail.do  	---forward---> /WEB-INF/views/member_detail.jsp
		 */
		/*
		 * 1.클라이언트 요청분석(URI)
		 */
		String requestURI = request.getRequestURI();
		System.out.println("requestURI:"+requestURI);
		String contextPath=request.getContextPath();
		System.out.println("contextPath:"+contextPath);
		String command = requestURI.substring(contextPath.length());
		System.out.println("command:"+command);
		
		/*
		 * 2.클라이언트요청에따른 업무실행(Service객체)
		 */
		
		String forwardPath="";
		if(command.equals("/member_main.do")) {
			forwardPath="forward:/WEB-INF/views/member_main.jsp";
		}else if(command.equals("/member_list.do")) {
			MemberService memberService = new MemberService();
			List<Member> memberList = memberService.member_list();
			request.setAttribute("memberList", memberList);
			forwardPath="forward:/WEB-INF/views/member_list.jsp";
		}else if(command.equals("/member_detail.do")) {
			String id = request.getParameter("id");
			MemberService memberService = new MemberService();
			Member member = memberService.member_detail(id);
			request.setAttribute("member", member);
			forwardPath="forward:/WEB-INF/views/member_detail.jsp";
		}else {
			request.setAttribute("error_msg","잘못된요청입니다.");
			forwardPath="forward:/WEB-INF/views/member_error.jsp";
		}
		/*
		 * 3.jsp forward or redirect
		 * 		redirect:member_main.do
		 *      forward:/WEB-INF/views/member_main.jsp
		 */
		/************ forward or redirect****************/
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path=pathArray[1];
		
		if(forwardOrRedirect.equals("forward")) {
		 	//forward
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}else if(forwardOrRedirect.equals("redirect")){
			//redirect
			response.sendRedirect(path);
		}
		/*************************************************/
	}

}