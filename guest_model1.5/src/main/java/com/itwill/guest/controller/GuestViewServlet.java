package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "";
		forwardPath = "forward:/WEB-INF/view/guest_view.jsp";
		
		/*********** Forward or Redirect ***********/
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
