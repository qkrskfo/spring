<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<c:if test="${!empty sUserId}">
		<li><a href="">${sUserId}님</a></li>
		<li><a href="user_view_myinfo.do">내정보</a></li>
		<li><a href="user_logout_action.do">로그아웃</a></li>
		<li><a href="user_list.do">전체회원리스트</a></li>
	</c:if>
	<c:if test="${empty sUserId}">
		<li><a href="user_login_form.do">로그인</a></li>
		<li><a href="user_write_form.do">회원가입</a></li>
	</c:if>
</ul>