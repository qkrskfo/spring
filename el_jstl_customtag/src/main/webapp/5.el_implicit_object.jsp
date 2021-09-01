<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
	pageContext.setAttribute("path", "page.jsp");
	request.setAttribute("path", "request.jsp");
	session.setAttribute("path", "session.jsp");
	application.setAttribute("path", "application.jsp");
	
	Cookie isCookie=new Cookie("id","summer");
	response.addCookie(isCookie);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장객체 (Implicit Object)</title>
</head>
<body>
	<h1>EL 내장객체 (Implicit Object)</h1>
	<ul>
		<li> -- pageScope, requestScope, sessionScope, applicationScope -- </li>
		<li>${path}</li> 
		<!-- 
		위에 다 "path"인데 어떤게 출력될까? 
		Scope에 "path"가 있는지 찾으러가는데, 
		좁은 범위인 개인사물함 pageContext로 부터 먼저 찾고, 
		찾으면 바로 출력. 다른거 안봐 
		-->
		<li>${pageScope.path}</li> <!-- {내장객체.키값} -->
		<li>${requestScope.path}</li>
		<li>${sessionScope.path}</li>
		<li>${applicationScope.path}</li>
		<li>${pageScope['path']}</li> <!-- MAP이기 때문에 이렇게도 접근하지만, 귀찮아~ 그냥 . 쓰면 되지 ㅋㅋㅋ -->
		<li>${requestScope['path']}</li> 
		<li>${sessionScope['path']}</li> 
		<li>${applicationScope['path']}</li>
		<li>------ param -------</li>
		<li>${param}</li>
		<li>${param.id}</li>
		<li>${param.name}</li>
		<li>${paramValues.hobby}</li>
		<li>${paramValues.hobby[0]}</li>
		<li>${paramValues.hobby[1]}</li>
		<li>${paramValues.hobby[2]}</li>
		<li>------ cookie -------</li>
		<li>${cookie}</li>
		<li>${cookie.JSESSIONID}</li>
		<li>${cookie.JSESSIONID.name}</li> <!-- 여기서 name은 프로퍼티 -->
		<li>${cookie.JSESSIONID.value}</li> <!-- 여기서 value는 프로퍼티 -->
		<li>${cookie.id.name}</li> 
		<li>${cookie.id.value}</li>
		<li>------ pageContext (내장객체x 빈o 그래서 ctrl+스페이스바 먹힘) -------</li>
		<li>${pageContext}</li>
		<li>${pageContext.request.method}</li>
		<li>${pageContext.session}</li>
		<li>${pageContext.session.id}</li>
		<li>${pageContext.session.maxInactiveInterval}</li>
		<li>${pageContext.response}</li>
		<li>${pageContext.response.contentType}</li>
	</ul>
</body>
</html>