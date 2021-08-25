package com.itwill.guest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/guest_list.do")
public class GuestListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "";
		
			try {
				GuestService guestService=new GuestService();
				//guestService=new GuestService();
				ArrayList<Guest> guestList=guestService.selectAll();
				//guestList=guestService.selectAll();
				request.setAttribute("guestList", guestList);
				forwardPath = "forward:/WEB-INF/view/guest_list.jsp";
				
			} catch(Exception e) {
				e.printStackTrace();
				/****** redirect [case1] ********/
				//response.sendRedirect("guest_error.do");
				forwardPath = "redirect:guest_error.do";
				
				
				/*** forward [case2] 
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/guest_error.jsp");
				rd.forward(request, response);		
				***/
				return;
			}
		/******* Forward or Redirect *******/
		String[] pathArray = forwardPath.split(":");
		String forwardOrRediret = pathArray[0];
		String path = pathArray[1];
		
		if(forwardOrRediret.equals("forward")) {
			//rediret
			//RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		} else if (forwardOrRediret.equals("redirect")) {
			response.sendRedirect(path);
			//redirect는 응답은 할 수 없음.
		}
		/******************************************/
		
	}

}
