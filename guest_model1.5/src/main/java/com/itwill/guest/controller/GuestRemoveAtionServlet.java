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
public class GuestRemoveAtionServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardPath = "";
		
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:guest_main.do";
		} else {
			try {
				String guest_noStr = request.getParameter("guest_no");
				GuestService guestService = new GuestService();
				guestService.deleteGuest(Integer.parseInt(guest_noStr));
				//response.sendRedirect("guest_list.jsp");
				forwardPath = "redirect:guest_list.do";
			} catch (Exception e) {
				e.printStackTrace();
				//response.sendRedirect("guest_error.do");
				forwardPath = "redirect:guest_error.do";
			}
		}
		
		/******* Forward or Redirect *******/
		String[] pathArray = forwardPath.split(":");
		String forwardOrRediret = pathArray[0];
		String path = pathArray[1];
		
		if(forwardOrRediret.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if (forwardOrRediret.equals("redirect")) {
			response.sendRedirect(path);
		}
		/******************************************/
		
	}
}
