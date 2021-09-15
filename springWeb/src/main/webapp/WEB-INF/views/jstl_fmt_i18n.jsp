<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${pageContext.request.locale}"/>
<fmt:setBundle basename="messages/guest"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL I18N[Internationalization]국제화</h1>
<ol>
	<li><fmt:message key="title.main"/></li>
	<li><fmt:message key="title.list"/></li>
	<li><fmt:message key="title.view"/></li>
	<li><fmt:message key="title.write"/></li>
</ol>

</body>
</html>