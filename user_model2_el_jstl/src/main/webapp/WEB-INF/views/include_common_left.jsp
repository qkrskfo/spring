<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>	
<%
	
	boolean isLogin = false;
	String sUserId=(String)session.getAttribute("sUserId");
	if(sUserId==null){
		isLogin=false;
	}else if(sUserId!=null){
		isLogin=true;
	}
%>    		
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	   <%if(isLogin){ %>
			<li><a href=""><%=sUserId%>님</a></li>
			<li><a href="user_view_myinfo.do">내정보</a></li>
			<li><a href="user_logout_action.do">로그아웃</a></li>
			<li><a href="user_list.do">전체회원리스트</a></li>
		<%}else{ %>
			<li><a href="user_login_form.do">로그인</a></li>
			<li><a href="user_write_form.do">회원가입</a></li>
		<%} %>
</ul>
