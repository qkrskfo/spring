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
//@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		요청URL-->
		  http://localhost/guest_model1/guest_view.do?guest_no=2
			0 . 요청객체인코딩설정 
		    1 . guest_no 파라메타받기
			2 . Service객체 메쏘드호출(업무처리)
		 */
		String forwardPath="";
		try {
			request.setCharacterEncoding("UTF-8");
			String guest_noStr=request.getParameter("guest_no");
			GuestService guestService=new GuestService();
			Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
			request.setAttribute("guest",guest);
			forwardPath="forward:/WEB-INF/view/guest_view.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="redirect:guest_error.do";
			//forwardPath="forward:/WEB-INF/view/guest_error.jsp";
		}
	
	
		/****** forward or redirect(반드시실행해야함)*********/
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
		/*****************************************************/
		return;
	}

}
