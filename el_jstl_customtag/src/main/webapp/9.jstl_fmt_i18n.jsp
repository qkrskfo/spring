<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	/*
	1. locale 객체 얻기, 생성
	2. ResourceBundle의 properties 파일 지정
	*/
	
	Locale locale = request.getLocale();
	ResourceBundle resourceBundle = ResourceBundle.getBundle("com/itwill/i18n/guest", locale);
	// guest.properties에서 .properties는 쓰면 안됨!
%>

<%-- 1. Locale 객체 설정 --%>
<%-- <fmt:setLocale value="ko" /> --%>
<fmt:setLocale value="${param.lang}" />
<%-- param의 타입은 map --%>

<%-- 2. ResourceBundle의 properties 파일지정(JSTL) 페이지 전역 --%>
<fmt:setBundle basename="com/itwill/i18n/guest" />

<!DOCTYPE html>
<html>-
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL I18N [Internationalization] 국제화</h1>
	<a href="9.jstl_formatter_i18n.jsp?lang=en">영어</a>
	<a href="9.jstl_formatter_i18n.jsp?lang=ja">일어</a>
	<a href="9.jstl_formatter_i18n.jsp?lang=zh">중국어</a>
	<a href="9.jstl_formatter_i18n.jsp?lang=ko">한국어</a>
	<ol>
		<li><%=resourceBundle.getString("title.main") %> </li>
		<%-- 2. ResourceBundle의 properties 파일지정(JSTL) 페이지 일부--%>
		<fmt:bundle basename="com/itwill/i18n/guest">
			<li> <fmt:message key="title.main" /></li>
			<li> <fmt:message key="title.list" /></li>
			<li> <fmt:message key="title.view" /></li>
			<li> <fmt:message key="title.write" /></li>
		</fmt:bundle>
		<li> <fmt:message key="title.main" /></li>
		<li> <fmt:message key="title.list" /></li>
		<li> <fmt:message key="title.view" /></li>
		<li> <fmt:message key="title.write" /></li>
	</ol>
</body>
</html>