<%@page import="com.itwill.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = "오늘은 날씨가 맑아요 기분이 상쾌해요";
	request.setAttribute("title", title);
	request.setAttribute("name", "JAMES");
	request.setAttribute("price", 1234567);
	request.setAttribute("weight", "74.5684");
	request.setAttribute("user", new User("guard", "1111", "김가드", "guard@gmail.com"));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL function[EL안에서 사용가능한]</h1>
	
	<ol>
		<li> -- 표준 EL안에서는 EL객체(속성객체)의 메소드 호출 가능 -- </li>
		<li>${title.substring(4, 7)}</li>
		<li>${name.toLowerCase()}</li>
		<li> -- 표준 EL안에서는 static method 메소드 호출 가능 -- </li>
		<li>${Integer.parseInt('45')+50}</li>
		<li>${Double.parseDouble(weight)*0.6}</li>
		<li>${user.}</li>
	</ol>
</body>
</html>