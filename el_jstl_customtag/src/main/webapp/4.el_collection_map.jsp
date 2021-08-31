<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Guest g1=new Guest(1,"NARAE","2020","pnr@gmail.com","http://www.naver.com","타이틀1","콘텐트1");
Guest g2=new Guest(2,"SUMMER","2021","summer@gmail.com","http://www.oaver.com","타이틀2","콘텐트2");
Guest g3=new Guest(3,"KARINA","2022","karina@gmail.com","http://www.paver.com","타이틀3","콘텐트3");

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
<h1>EL Collection(배열,List),Map 출력</h1><hr/>
<ul>
	<li>---------List(배열)---------------</li>
	<li>${guestList}</li>
	<li>${guestList[0]}</li>
	<li>${guestList[0].guest_no}</li>
	<li>${guestList[0].guest_name}</li>
	<li>${guestList[0].guest_email}</li>
	<li>${guestList[0].guest_homepage}</li>
	<li>${guestList[0].guest_title}</li>
	<li>${guestList[0].guest_content}</li>
	
	<li>${guestList[1]}</li>
	<li>${guestList[1].guest_no}</li>
	<li>${guestList[1].guest_name}</li>
	<li>${guestList[1].guest_email}</li>
	<li>${guestList[1].guest_homepage}</li>
	<li>${guestList[1].guest_title}</li>
	<li>${guestList[1].guest_content}</li>
	
	<li>${guestList[2]}</li>
	<li>${guestList[2].guest_no}</li>
	<li>${guestList[2].guest_name}</li>
	<li>${guestList[2].guest_email}</li>
	<li>${guestList[2].guest_homepage}</li>
	<li>${guestList[2].guest_title}</li>
	<li>${guestList[2].guest_content}</li>
	<li> ---- for문 ----</li>
	<%
		for(int i=0; i<guestList.size(); i++) {
			//request.setAttribute("i", i);
			pageContext.setAttribute("i", i); 
	%>
	
			<li>${guestList[i].guest_no}</li>
			<li>${guestList[i].guest_name}</li>
			<li>${guestList[i].guest_email}</li>
			<li>${guestList[i].guest_homepage}</li>
			<li>${guestList[i].guest_title}</li>
			<li>${guestList[i].guest_content}</li>
	<%
		}
	%>
	
	<li> ---- MAP ----</li>
	<li>${guestMap}</li>
	<li>${guestMap.g1}</li>
	<li>${guestMap.g1.guest_no}</li>
	<li>${guestMap.g1.guest_name}</li>
	<li>${guestMap.g1.guest_email}</li>
	
	<li>${guestMap['g2']}</li>
	<li>${guestMap['g2'].guest_no}</li>
	<li>${guestMap['g2'].guest_name}</li>
	<li>${guestMap['g2'].guest_email}</li>
	
</ul>
</body>
</html>