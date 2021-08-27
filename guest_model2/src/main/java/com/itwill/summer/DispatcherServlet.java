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
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestViewServlet;

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
		 * 1.클라이언트 요청URI를 사용해서 요청분석
		 */
		String command=request.getRequestURI().substring(request.getContextPath().length());
		
		/*
		 * 2.클라이언트요청에따른 업무실행(Service객체)
		 */
		/*#################################################################*/
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
		 * 
		 * 데이터를 넘겨야될땐 FORWARD
		 * 데이터를 안넘길땐 REDIRECT
		 * FORWARD를 쓸 때 발생하는 문제점들이 있어서 REDIRECT가 좋음
		 * 	
		 */
		String forwardPath="";
		Controller controller=null;
		if(command.equals("/guest_main.do")) {
			/********************guest_main.do******************/
			controller=new GuestMainController();
			/**************************************************/
		}else if(command.equals("/guest_list.do")) {
			/********************guest_list.do******************/
			controller=new GuestListController();
			/**************************************************/
		}else if(command.equals("/guest_view.do")) {
			/********************guest_view.do******************/
			controller=new GuestViewController();
			/**************************************************/
		}else if(command.equals("/guest_write_form.do")) {
			/**************guest_write_form.do*****************/
			forwardPath="forward:/WEB-INF/view/guest_write_form.jsp";
			/**************************************************/
		}else if(command.equals("/guest_write_action.do")) {
			/*************guest_write_action.do****************/
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
				}
			}
			/**************************************************/
		}else if(command.equals("/guest_modify_form.do")) {
			/**************guest_modify_form.do****************/
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				try {
					String guest_noStr=request.getParameter("guest_no");
					GuestService guestService=new GuestService();
					Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("guest",guest);
					forwardPath="forward:/WEB-INF/view/guest_modify_form.jsp";
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/view/guest_error.jsp";
				}
			}
			/**************************************************/
		}else if(command.equals("/guest_modify_action.do")) {
			/*************guest_modify_action.do***************/
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
			/**************************************************/
		}else if(command.equals("/guest_remove_action.do")) {
			/*************guest_remove_action.do***************/
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
			/**************************************************/
		}else if(command.equals("/guest_error.do")){
			/******************guest_error.do******************/
			forwardPath = "/WEB-INF/view/guest_error.jsp";
			/**************************************************/
		}
		// 이렇게 되면 error.do로 오는 애들 말고 다른 애들은 에러페이지가 안뜨는뎅?...
		
		
		//위에서 자꾸 반복하지말고, 다 끝난다음에 여기서 호출하면 다 들어가잖아
		forwardPath=controller.handleRequest(request, response);
		
		
		
		
		
		/*#################################################################*/
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