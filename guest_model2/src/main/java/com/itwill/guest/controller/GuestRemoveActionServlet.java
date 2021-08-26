package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_remove_action.do")
public class GuestRemoveActionServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		0. GET방식이면 guest_main.do redirection
		1. guest_no 파라메타바끼
		2. GuestService.deleteGuest()메쏘드호출
		3. 성공 -->guest_list.do redirection
		   실패-->guest_error.doredirection
		*/
		String forwardPath="";
		
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:guest_main.do";
		}else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				GuestService guestService = new GuestService();
				guestService.deleteGuest(Integer.parseInt(guest_noStr));
				forwardPath="redirect:guest_list.do";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="redirect:guest_error.do";
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
