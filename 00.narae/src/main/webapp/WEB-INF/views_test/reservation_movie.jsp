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
		<li>제목: 
		<a class="title" href="reservation_summary" no="${movie.movieNo }">${movie.title}</a></li>
		<form>
			<input class="movie" type="button" name="movie" value="${movie.title}" no="${movie.movieNo }"> 
		</form>
	</c:forEach>
	<br>
	<br>
	<br>
	<div id="summary"></div>
	<div id="movieDateList"></div>

	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		$("a.title").click(
				function(e) {
					e.preventDefault();
					console.log($(e.target).attr("no"));
					location.href = "reservation_summary?movieNo="
							+ $(e.target).attr("no");
				});

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

		/* function callByAjax() {
			var form = document.form1;
			var num1 = form.num1.value;
			alert(num1);

			var action = form.action;
			action = "main";

			$.ajax({
				url : 'reservation_movie',
				type : 'get',
				data : {
					'id' : 'admin'
				},
				success : function(data) {
					alert(data);
				},
				error : function(err) {
					alert("100");
				}
			});

		}; */
		
	</script>

	<!-- <form name="form1" action="reservation_movie" method="get">
		<div>
			<input onclick="callByAjax()" type="button" value="ajax실행버튼">
		</div>
		<div>
			<input type="text" name="num1" placeholder="영화제목">
		</div>
	</form> -->


	<%-- <script type="text/javascript">
	$(function(){
		setInterval(function(){
			$.ajax({
				url:'/reservation_movie',
				method:'GET',
				dataType:'xml',
				success:function(){
					alert("통신 성공")
				}
				error: function() {
					alert("통신 실패")
				}
			});
		});
	</script> --%>

	<!-----------------------위 -- 링크달린 제목---------------------------->
	<!-----------------------밑 -- 링크 누르면 나오는 간단설명---------------------------->


	<!-- 영화리스트  -->
	<%-- <c:forEach items="${movieList}" var="movie">
		<ul>
			<img src="${movie.posterImage}" width="100" height="100" alt="영화이미지">
			<li>${movie.title }</li>
			<li>장르: ${movie.genre }</li>
			<li>상영시간: ${movie.runningtime }</li>
			<li>${movie.rating }관람가</li>
		</ul>

		<hr>
	</c:forEach> --%>
</body>
</html>