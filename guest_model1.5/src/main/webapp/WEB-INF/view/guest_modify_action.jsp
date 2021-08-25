<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
0 . GET방식이면 guest_write_form.jsp redirection
0 . 요청객체 인코딩설정
1 . 파라메타받기 
	- 5개받기
2. GuestService.updateGuest()메쏘드호출
3. 성공 -->guest_view.jsp?guest_no=34 redirection
   실패 -->guest_error.jsp      redirection
*/

%>