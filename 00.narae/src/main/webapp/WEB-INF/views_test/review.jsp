<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나는리뷰
review
 <h4>${review1movie}</h4>
 
 <h4>${review1movie.reviewNo}</h4>
<h4>${review1movie.member.id}</h4>
<h4>${review1movie.reviewComment }</h4>
<h4>${reviewAvg }</h4>


</body>
</html>