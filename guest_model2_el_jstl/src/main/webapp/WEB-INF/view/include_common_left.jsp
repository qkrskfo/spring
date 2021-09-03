<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <fmt:setLocale value="en" /> --%>
<fmt:setBundle basename="com/itwill/guest/guest" />

<ul>
	<li>
	<a href="guest_main.do?lang=ko"><fmt:message key="menu.language.ko"/></a>|
	<a href="guest_main.do?lang=en"><fmt:message key="menu.language.en"/></a>
	</li>
</ul>
<p>
	<strong><fmt:message key="menu.title"/></strong>
</p>
<ul>
	<li><a href="guest_main.do"><fmt:message key="menu.home"/></a></li>
	<li><a href="guest_list.do"><fmt:message key="menu.list"/></a></li>
	<li><a href="guest_write_form.do"><fmt:message key="menu.write"/></a></li>
</ul>
