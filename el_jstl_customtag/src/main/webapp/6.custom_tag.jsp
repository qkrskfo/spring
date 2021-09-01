<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--@ include file = "xxx.jspf" --%>   
    
<%@ taglib prefix="itwill" uri="http://www.itwill.co.kr/jsp/simpleTag" %>
<!-- prefix 이름은 하는일, 성격에 따라 주는 것. itwill에 속한~ 이런 의미를 갖는 것 -->


<%--
<jsp:forward page = "xx.jsp"></jsp:forward>
<itwill:forward page = "xx.jsp"></itwill:forward>
<uniwill:forward page = "xx.jsp"></uniwill:forward>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>custom tag [사용자 정의 태그]</h1><hr>
	<itwill:hello></itwill:hello>
	<itwill:hello/>
</body>
</html>