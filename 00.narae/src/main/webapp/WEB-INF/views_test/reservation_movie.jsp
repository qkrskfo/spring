<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예약 영화리스트랑 영화정보 보여주기</title>

</head>
<body>

	<c:forEach items="${movieList}" var="movie">
		<li>제목: <a class="title" href="reservation_summary"
			no="${movie.movieNo }">${movie.title}</a></li>
		<form>
			<input class="movie" type="button" name="movie"
				value="${movie.title}" no="${movie.movieNo }">
		</form>
	</c:forEach>
	<br>
	<br>
	<br>
	<div id="summary"></div>
	<div id="movieDateList"></div>
	<div id="movieInfo"></div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		
	// 누르면 해당 영화 간단 정보 페이지로 이동
		$("a.title").click(
				function(e) {
					e.preventDefault();
					console.log($(e.target).attr("no"));
					location.href = "reservation_summary?movieNo="
							+ $(e.target).attr("no");
				});

	//ajax 누르면 해당 영화 간단 정보 출력
		$(".movie").click(function(e) {
			$.ajax({
				url : 'reservation_summary',
				type : 'post',
				data : "movieNo=" + $(e.target).attr("no"),
				success : function(data) {
					$("#summary").html(data);
				},
				error : function(err) {
					alert("100");
				}
			});

			$.ajax({
				url : 'movie_to_dateList',
				type : 'post',
				data : "movieNo=" + $(e.target).attr("no"),
				success : function(data) {
					$("#movieDateList").html(data);
				},
				error : function(err) {
					alert("100");
				}
			});
		});
	</script>

</body>
</html>