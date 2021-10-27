<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Playing</title>

<style type="text/css">
	.rating[rating="전체"] {
		color: #ffffff;
		background: #00ab24;
	}
	.rating[rating="12세"] {
		color: #ffffff;
		background: #0589f9;
	}
	.rating[rating="15세"] {
		color: #ffffff;
		background: #f98700;
	}
	.poster {
		width: 241px;
		height: 345px;
	}
	a.title {
		text-decoration: none;
		color: black;
		font-weight: bold;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<c:forEach items="${movieList}" var="movie">
	<ul>
		<li><a href="#"><img class="poster" alt="포스터" src="${movie.posterImage }" no="${movie.movieNo }"></a></li>
		<li class="rating" rating="${movie.rating }">${movie.rating }</li>
		<li>번호: ${movie.movieNo }</li>
		<li>제목: <a class="title" href="#">${movie.title }</a></li>
		<li>개봉일: ${movie.openDate }</li>
		<li>개봉일[포맷 적용]: <s:eval expression="new java.text.SimpleDateFormat('yyyy/MM/dd').format(movie.openDate)"></s:eval></li>
		<li>감독: ${movie.director }</li>
		<li>배우: ${movie.actors }</li>
		<li>장르: ${movie.genre }</li>
		<li>상영시간: ${movie.runningtime }</li>
		<li>줄거리: ${movie.summary }</li>
	</ul>
	
	<hr>
</c:forEach>
<script>
	$(".poster").click(function (e) {
		location.href = "movie_info?movieNo=" + $(e.target).attr("no");
	});
</script>
</body>
</html>