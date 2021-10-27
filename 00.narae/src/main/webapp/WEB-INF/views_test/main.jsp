<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<h1>메인화면</h1>
	<div>
		<c:choose>	
		<c:when test="${empty(sMemberId)}">
			<a href="signup">회원 가입</a><br>
			<a href="login">로그인</a><br>
		</c:when>
		<c:otherwise>
			<h2>sMemberId: ${sMemberId}</h2><br>
			<a href="logout_action">로그아웃</a><br>
			<a href="member_info">내 정보</a><br>
			<a href="member_remove_action">회원 탈퇴</a><br>
			<a href="member_ticket_history">나의 예매내역</a><br>
			<a href="#">빠른 예매</a><br>
		</c:otherwise>
		</c:choose>
		<br><br>
		<a href="playing">상영중인 영화</a> (영화 상세정보, 리뷰)<br>
	</div>
</body>
</html>