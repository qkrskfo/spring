package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
//@WebServlet("/guest_modify_action.do")
public class GuestModifyActionServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		0 . GET방식이면 guest_write_form.jsp redirection
		0 . 요청객체 인코딩설정
		1 . 파라메타받기 
			- 5개받기
		2. GuestService.updateGuest()메쏘드호출
		3. 성공 -->guest_view.jsp?guest_no=34 redirection
		   실패 -->guest_error.jsp      redirection
		*/
		String forwardPath="";
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				request.setCharacterEncoding("UTF-8");
				String guest_noStr=request.getParameter("guest_no");
				String guest_name=request.getParameter("guest_name");
				String guest_email=request.getParameter("guest_email");
				String guest_homepage=request.getParameter("guest_homepage");
				String guest_title=request.getParameter("guest_title");
				String guest_content=request.getParameter("guest_content");
				Guest updateGuest = new Guest(
						Integer.parseInt(guest_noStr),guest_name,
						null,guest_email,guest_homepage,
						guest_title,guest_content);
				int updateRowCount = new GuestService().updateGuest(updateGuest);
				forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/view/guest_error.jsp";
			}
		}
		
		
		
		
		
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
