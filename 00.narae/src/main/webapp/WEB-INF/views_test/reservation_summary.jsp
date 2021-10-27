<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
			<img src="${movie.posterImage}" width="100" height="100" alt="영화이미지">
			<li>${movie.title }</li>
			<li>장르: ${movie.genre }</li>
			<li>상영시간: ${movie.runningtime }</li>
			<li>${movie.rating }관람가</li>
</ul>
</body>
</html>