<%@page import="com.itwill.member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> memberList = (List<Member>)request.getAttribute("memberList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member_list.jsp</h1><hr>
<div>
	<a href='member_main.do'>메인</a>
</div>
<ol>
	<%for(Member member:memberList){ %>
	<li><a href='member_detail.do?id=<%=member.getId()%>'><%=member.toString()%></a></li>
	<% }%>
</ol>
</body>
</html>