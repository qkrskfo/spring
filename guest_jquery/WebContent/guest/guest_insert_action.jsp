<%@page import="com.itwill.guest.GuestDaoImpl"%>
<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/plain; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String result = "false";
try {
	request.setCharacterEncoding("utf-8");
	String g_name = request.getParameter("guest_name");
	String g_email = request.getParameter("guest_email");
	String g_homepage = request.getParameter("guest_homepage");
	String g_title = request.getParameter("guest_title");
	String g_content = request.getParameter("guest_content");
	/**********************************************************/
	String method = request.getMethod();
	System.out.println("*********jQuery Ajax요청정보**************");
	System.out.println("0.jQuery Ajax요청URL    :" + request.getRequestURI());
	System.out.println("1.jQuery Ajax요청방식    :" + method);
	System.out.println("2.jQuery Ajax요청파라메타:" + g_name + "," + g_title);
	System.out.println("******************************************");
	/**********************************************************/
	Guest guest = new Guest();
	guest.guest_content = g_content;
	guest.guest_email = g_email;
	guest.guest_title = g_title;
	guest.guest_name = g_name;
	guest.guest_homepage = g_homepage;
	//2.DAO 메쏘드 호출
	GuestDao guestDao = new GuestDaoImpl();
	int insertRowCount = guestDao.insertGuest(guest);
	result = "true";
} catch (Exception e) {
	result = "false";
}
%>
<%=result%>