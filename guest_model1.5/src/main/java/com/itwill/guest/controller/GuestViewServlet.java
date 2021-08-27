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
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		요청URL-->
		  http://localhost/guest_model1/guest_view.jsp?guest_no=2
			0 . 요청객체인코딩설정 
		    1 . guest_no 파라메타받기
			2 . Service객체 메쏘드호출(업무처리)
		*/
		
		String forwardPath = "";
		
		/*
		if(guest_noStr==null|| guest_noStr.equals("")){
			//response.sendRedirect("guest_list.jsp");
			//return;
			forwardPath = "redirect:guest_list.do";
		} else {
		*/
			try {
				request.setCharacterEncoding("UTF-8");
				String guest_noStr=request.getParameter("guest_no");
				GuestService guestService=new GuestService();
				Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
				
				if(guest==null) {
				/*
					out.print("<script>");
					out.print("alert('존재하지 않는 게시물입니다.');");
					out.print("location.href='guest_list.jsp';");
					out.print("</script>");
				 */
					request.setAttribute("GUEST_NOT_FOUND_MSG", "존재하지 않는 게시물입니다.");
				} else {
					request.setAttribute("guest", guest);
				}
				forwardPath = "forward:/WEB-INF/view/guest_view.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath="rediret:guest_error.do";
			}
		
		// 중간에 return하면 안됨. 밑에꺼를 반드시 실행해야함!
		/*********** Forward or Redirect (반드시 실행해야 함) ***********/
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
		return;
	}

}
