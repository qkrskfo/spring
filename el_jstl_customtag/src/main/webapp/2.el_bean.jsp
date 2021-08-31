<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Car c = new Car(1, "TESLA", "RED");
	Student s = new Student(1, "KIM", new Car(2222,"KB", "BLACK"));
	Date d = new Date();
	Guest g = new Guest(999, "구구구", "2021-08-31", "guest@gmail.com", "http://www.naver.com", "오늘은 비가 와요", "EL을 공부해요");
	User u = new User("guard", "1111", "가아드", "guard@gmail.com");
	
	request.setAttribute("car", c);
	request.setAttribute("student", s);
	request.setAttribute("date", d);
	request.setAttribute("guest", g);
	request.setAttribute("user", u);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL BEAN 객체 출력</h1> <hr>
	<ul>
		<li>${car}</li>
		<li>${car.model}</li>
		<li>${car.getModel()}</li>
		<li>${car.color}</li>
		<li>${student}</li>
		<li>${student.no}</li>
		<li>${student.name}</li>
		<li>${student.car}</li>
		<li>${student.car.no}</li>
		<li>${student.getCar().getNo()}</li>
		<li>${student.car.model}</li>
		<li>${student.car.color}</li>
		<li>${date}</li>
		<li>${date.year+1900}년</li>
		<li>${date.month+1}월</li>
		<li>${date.date}일</li>
		<li>${guest}</li> 
		<li>${guest.guest_no}</li> 
		<li>${guest.guest_name}</li> 
		<li>${user}</li>
		<li>${user.userId}</li>
		<li>${user.name}</li>
		<li>${user.email}</li>
	</ul>
</body>
</html>