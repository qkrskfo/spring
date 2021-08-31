<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("sUserId", "iampnr");

	request.setAttribute("name", "카리나");
	request.setAttribute("age", new Integer(34));
	request.setAttribute("age", 29); //boxing
	request.setAttribute("weight", 48.23); //boxing
	request.setAttribute("married", true); //boxing
	
	double height = 174.2;
	String address="서울시민";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>EL String, Wrapper 객체 출력</h1>
	<ol>
		<li>${sUserId}</li>
		<li>${name}</li>
		<li>${name.substring(1)}</li>
		<li>${age}</li>
		<li>${weight}</li>
		<li>${married}</li>
		<li>아래 8,9번은 EL 출력 불가능 (속성객체가 아님)</li>
		<li>height, address는 속성객체가 아니라서 안나오는 것!</li>
		<li>${height}</li>  
		<li>${address}</li>
		
		<li><%=height%></li>
		<li><%=address%></li>
	</ol>
</body>
</html>