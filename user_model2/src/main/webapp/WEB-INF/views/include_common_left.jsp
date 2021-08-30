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
			<li><a href="user_view_myinfo.jsp">내정보</a></li>
			<li><a href="user_logout_action.jsp">로그아웃</a></li>
			<li><a href="user_list.jsp">전체회원리스트</a></li>
		<%}else{ %>
			<li><a href="user_login_form.jsp">로그인</a></li>
			<li><a href="user_write_form.jsp">회원가입</a></li>
		<%} %>
</ul>
