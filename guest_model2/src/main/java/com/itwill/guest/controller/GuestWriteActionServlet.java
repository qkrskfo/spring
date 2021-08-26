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
//@WebServlet("/guest_write_action.do")
public class GuestWriteActionServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		forwardPath="/WEB-INF/view/guest_write_action.jsp";
		
		/*
		0 . GET방식이면 guest_write_form.do redirection
		0 . 요청객체 인코딩설정
		1 . 파라메타받기 
			- 5개받기
		2 . Service객체 메쏘드호출(업무처리)
			- GuestService.insertGuest()
		3 . 요청클라이언트로 응답 
			- 성공:guest_list.do 로 redirection
			- 실패(예외):guest_error.do로 redirection
		*/
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				request.setCharacterEncoding("UTF-8");
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				Guest guest = new Guest(0, guest_name, null, guest_email, guest_homepage, guest_title, guest_content);
				GuestService guestService = new GuestService();
				int insertRowCount = guestService.insertGuest(guest);
				forwardPath="redirect:guest_list.do";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:guest_error.do";
				//forwardPath="forward:/WEB-INF/view/guest_error.jsp";
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
