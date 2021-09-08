package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

/*
 * 클라이언트의 모든요청(*.do)을 받는 서블릿(Controller)
 */
public class DispatcherServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 1.클라이언트 요청URI를 사용해서 요청분석
		 */
		String command=request.getRequestURI().substring(request.getContextPath().length());
		
		/*
		 * 2-1.클라이언트요청에따른 업무실행 Controller객체의생성
		 */
		String forwardPath="";
		Controller controller=null;
		/*#################################################################*/
		if(command.equals("/guest_main.do")) {
			controller=new GuestMainController();
		}else if(command.equals("/guest_list.do")) {
			controller=new GuestListController();
		}else if(command.equals("/guest_view.do")) {
			controller=new GuestViewController();
		}else if(command.equals("/guest_write_form.do")) {
			controller=new GuestWriteFormController();
		}else if(command.equals("/guest_write_action.do")) {
			controller=new GuestWriteActionController();
		}else if(command.equals("/guest_modify_form.do")) {
			controller=new GuestModifyFormController();
		}else if(command.equals("/guest_modify_action.do")) {
			controller=new GuestModifyActionController();
		}else if(command.equals("/guest_remove_action.do")) {
			controller=new GuestRemoveActionController();
		}else if(command.equals("/guest_error.do")){
			controller=new GuestErrorController();
		}
		/*#################################################################*/
		/*
		 * 2-2.클라이언트요청에따른 업무실행 Controller객체의실행결과(이동할 패쓰) 반환받기
		 */
		forwardPath=controller.handleRequest(request, response);
		
		
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
