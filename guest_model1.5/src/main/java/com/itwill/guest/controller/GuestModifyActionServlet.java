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
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/guest_modify_action.do")
public class GuestModifyActionServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "";
		
		if (request.getMethod().equalsIgnoreCase("GET")) {
			forwardPath="redirect:guest_main.do";
		} else {
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
				//response.sendRedirect("guest_view.jsp?guest_no="+guest_noStr);
				forwardPath = "redirect:guest_view.do?guest_no="+guest_noStr;
				//forwardPath = "forward:guest_view.do"; // redirect는 보임(클라이언트에게 알려줘, 보여죠), forward는 사용자에게 보이지 않는 url임(클라이언트가 모르게 이동시키는 것)
				// forward로 들어가면 modifyAction이 url에 남아있어서, 새로고침하면 계속 글이 수정됨. 
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/view/guest_error.jsp";
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
