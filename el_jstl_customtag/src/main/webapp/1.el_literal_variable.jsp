<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*

*/

	pageContext.setAttribute("int1", 10);
	pageContext.setAttribute("int2", 20);
	pageContext.setAttribute("double1", 3.14159);
	pageContext.setAttribute("double2", 0.55639);
	pageContext.setAttribute("string1", "KIM");
	pageContext.setAttribute("string2", "KYUNG HO");
	pageContext.setAttribute("bool1", true);
	pageContext.setAttribute("bool2", false);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 리터럴, 변수</h1>
	<ul>
		<li> -- EL 리터럴(상수) -- </li>
		<li>정수형리터럴 ${12345}</li>
		<li>실수형리터럴 ${3.14159}</li>
		<li>논리형리터럴 ${true}</li>
		<li>문자형리터럴 ${'문자1'}</li>
		<li>문자형리터럴 ${"문자2"}</li>
		<li> -- EL 변수 --</li>
		<li>${int1}</li>
		<li>${int2}</li>
		<li>${double1}</li>
		<li>${double2}</li>
		<li>${string1}</li>
		<li>${string2}</li>
		<li>${bool1}</li>
		<li>${bool2}</li>
	</ul>
</body>
</html>