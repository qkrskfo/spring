<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	Guest g1=new Guest(1,"KIM","2020","guard1@gmail.com","http://www.naver.com","타이틀1","콘텐트1");
	Guest g2=new Guest(2,"SIM","2021","guard2@gmail.com","http://www.oaver.com","타이틀2","콘텐트2");
	Guest g3=new Guest(3,"DIM","2022","guard3@gmail.com","http://www.paver.com","타이틀3","콘텐트3");
	
	ArrayList<Guest> guestList=new ArrayList<Guest>();
	guestList.add(g1);
	guestList.add(g2);
	guestList.add(g3);
	
	HashMap<String,Guest> guestMap=new HashMap<String,Guest>();
	guestMap.put("g1", g1);
	guestMap.put("g2", g2);
	guestMap.put("g3", g3);
	request.setAttribute("guestList", guestList);
	request.setAttribute("guestMap", guestMap);
	
%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core forEach tag</h1><hr>
<ul>
	

	<li>-------ArrayList[배열]-------</li>
	<%
	for(Guest guest:guestList){ 
		pageContext.setAttribute("guest", guest);
	%>
		<li>${guest}</li>	
	<%
	}
	%>
	<c:forEach items="${guestList}" var="guest">
		<li>${guest} : ${guest.guest_no},${guest.guest_name},${guest.guest_email}</li>
	</c:forEach>
	<li>---------------Map--------------</li>
	<c:forEach items="${guestMap}" var="guestEntry">
		<li>${guestEntry} -- </li> 
		<li>${guestEntry.key} = ${guestEntry.value}==>${guestEntry.value.guest_no},${guestEntry.value.guest_name}</li>
	</c:forEach>
</ul>	
</body>
</html>