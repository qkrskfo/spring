<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*

*/

	pageContext.setAttribute("int1", 10);
	pageContext.setAttribute("int2", 20);
	pageContext.setAttribute("double1", 3.14159);
	pageContext.setAttribute("double2", 0.7);
	pageContext.setAttribute("string1", "KIM");
	pageContext.setAttribute("string2", "KYUNG HO");
	pageContext.setAttribute("bool1", true);
	pageContext.setAttribute("bool2", false);

	pageContext.setAttribute("married", true);
	pageContext.setAttribute("age", 31);
	pageContext.setAttribute("weight", 51.21);
	pageContext.setAttribute("height", 164);
	
	
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
		<li> -- EL 변수[속성이름] --</li>
		<li>${int1}</li>
		<li>${int2}</li>
		<li>${double1}</li>
		<li>${double2}</li>
		<li>${string1}</li>
		<li>${string2}</li>
		<li>${bool1}</li>
		<li>${bool2}</li>
		<li> -- EL 연산자 --</li>
		<li>${12+89}</li>
		<li>${1-2}</li>
		<li>${34*12}</li>
		<li>${1/2}</li>
		<li>${(1+2)-89/(34+90)}</li>
		<li>${int1+int2}</li>
		<li>${int1-int2}</li>
		<li>${int1*int2}</li>
		<li>${int1/int2}</li>
		<li>${(int1*int2)/3-90}</li>
		<li>${double1+double2+0.23}</li>
		<li>age >=30 --> ${age >=30}</li>
		<li>age < 30 --> ${age < 30}</li>
		<li>age ge 30 --> ${age ge 30}</li> <!-- 크냐 gt (greater than) 크거나 같냐 gte (greater than or equal) -->
		<li>age lt 30 --> ${age lt 30}</li> <!-- 작냐 lt (less than) -->
		<li>30대인가요? ${age>=30 && age<40}</li>
		<li>30대이고 키가 160 이상인가요? ${(age>=30 && age<40) && height>=160}</li>
	</ul>
</body>
</html>