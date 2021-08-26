package com.itwill.summer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
		<<요청 url(command)>>
			/guest_main.do  
			/guest_list.do			
			/guest_view.do			
			/guest_write_form.do	
			/guest_write_action.do	
			/guest_modify_form.do	
			/guest_modify_action.do	
			/guest_remove_action.do	
			/guest_error.do			
		*/
		
		/*
		 * 1.클라이언트 요청URI를 사용해서 요청분석
		 */
		String command = request.getRequestURI().substring(request.getContextPath().length());
		
		/*
		 * 2.클라이언트요청에따른 업무실행(Service객체)
		 */
		String forwardPath = "";
		if(command.equals("/guest_main.do")) {
			forwardPath="forward:/WEB-INF/view/guest_main.jsp";
		} else if(command.equals("/guest_list.do")) {
			
		} else if(command.equals("/guest_view.do")) {
			
		} else if(command.equals("/guest_write_form.do")) {
			
		} else if(command.equals("/guest_write_action.do")) {
			
		} else if(command.equals("/guest_modify_form.do")) {
			
		} else if(command.equals("/guest_modify_action.do")) {
			
		} else if(command.equals("/guest_remove_action.do")) {
			
		} else if(command.equals("/guest_error.do")) {
			
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