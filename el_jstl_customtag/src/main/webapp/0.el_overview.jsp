<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setAttribute("a", new String("속성객체1"));
	request.setAttribute("b", new Integer(2));
	request.setAttribute("c", new Boolean(true));
	request.setAttribute("d", "속성객체2");
	request.setAttribute("e", 3); // boxing돼서 들어감
	request.setAttribute("f", false); //boxing
	request.setAttribute("guest", new Guest(1, "KIM", "2021-08", "summer@gmail.com", "http://www.google.com", "타이틀", "콘텐트"));
	request.setAttribute("user", new User("summer", "1111", "박나래", "summer@gmail.com")); 

	String str1 = "난 JSP 로컬 변수";
	int int1 = 1234;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL (Expression Language)</h1>
	<ul>
		<li>-- NO EL --</li>
		<li><%=request.getAttribute("a")%></li>
		<li><%=request.getAttribute("b")%></li>
		<li><%=request.getAttribute("c")%></li>
		<li><%=request.getAttribute("d")%></li>
		<li><%=request.getAttribute("e")%></li>
		<li><%=request.getAttribute("f")%></li>
		<li><%=request.getAttribute("guest")%></li>
		<li><%=((Guest)request.getAttribute("guest")).getGuest_no()%></li>
		<li><%=((Guest)request.getAttribute("guest")).getGuest_name()%></li>
		<li><%=((Guest)request.getAttribute("guest")).getGuest_email()%></li>
		<li><%=request.getAttribute("user")%></li>
		<li><%=((User)request.getAttribute("user")).getUserId()%></li>
		<li><%=((User)request.getAttribute("user")).getName()%></li>
		<li><%=((User)request.getAttribute("user")).getEmail()%></li>
		<li>msg:<%=request.getAttribute("msg")%></li>
		<li>str1:<%=str1%></li>
		<li>int1:<%=int1%></li>
		<li>-- EL --</li>
		<li>${a}</li>
		<li>${b}</li>
		<li>${c}</li>
		<li>${d}</li>
		<li>${e}</li>
		<li>${f}</li>
		<li>${guest}</li>
		<li>${guest.guest_no}</li>
		<li>${guest.getGuest_no()}</li>
		<li>${user}</li>
		<li>${user.userId}</li>
		<li>${user.getName()}</li>
		<li>msg:${msg}</li>
		<li>str1:${str1}</li>
		<li>int1:${int1}</li>
	</ul>
	<!-- el은 컨텐트 어시스트가 안뜸!(ctrl+space bar) -->
</body>
</html>