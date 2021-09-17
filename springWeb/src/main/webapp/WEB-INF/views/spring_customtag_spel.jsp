<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%--
	request.setAttribute("price0", 345345435);
	request.setAttribute("name0", "kim eun hi");
	
	request.setAttribute("price1", 231151);
	request.setAttribute("name1", "LEE HYO LEE");
	request.setAttribute("married1", true);
	
	request.setAttribute("price2", 12345456);
	request.setAttribute("name2", "김태희");
	request.setAttribute("married2", true);
	
	request.setAttribute("guest", 
				new Guest(1, "김수미", new Date().toLocaleString(),
						"guard@naver.com", "http://www.google.com",
						"오늘은목요일", "Spring EL에대해 공부합니다."));
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<h1>Spring CustomTag ,SPEL</h1><hr/>
<p>
	- Spring CustomTag : Spring에서 정의한태그<br>
	- SPEL(Spring Expression Language)
	   --> Spring CustomTag(eval) 의 속성안에서 사용가능한 표현언어(식)
</p>
<ul>
	<li>문자열리터럴(EL):${'KIM'.replace('K','N')} </li>
	<li>문자열리터럴(SPEL):<s:eval expression="'KIM'.replace('K','N')" /></li>
	<li>숫자리터럴(EL):</li>
	<li>숫자리터럴(SPEL):</li>
	<li>논리리터럴(EL):</li>
	<li>논리리터럴(SPEL):</li>
	<li>변수1(EL):</li>
	<li>변수2(EL Bean):</li>
	<li>
		변수1(SPEL):
		
	</li>
	<li>
		변수2(SPEL Bean):
		
	</li>
	<li>SPEL + EL(문자열리터럴):
		
	</li>
	<li>SPEL + EL(숫자리터럴):
		
	</li>
	<li>SPEL(SCOPE객체에 등록된 숫자변수(속성이름)):
		
	</li>
	<li>SPEL(SCOPE객체에 등록된 문자열변수(속성이름)):
		
	</li>
	<li>EL(SCOPE객체에 등록된 빈객체(DTO):
		
	</li>
	<li>SPEL(SCOPE객체에 등록된 빈객체(DTO):
		
	</li>
	<li>
		클래스생성자호출(EL에서는 호출불가능):<br>
		
	</li>
	<li>
		클래스생성자호출(SPEL에서는 호출가능):<br>
		
		<br>
		
	</li>
	<li>
		@를 이용해서 SpringContainer에 등록된 빈사용가능
		- @elBean:<br/>
		- @elBean.member1:<br/>
		- @elBean.printMembers():<br/>
	</li>
</ul>
</body>
</html>