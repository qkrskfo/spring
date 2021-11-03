<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty(movie)}">
	<script>
		alert('상영이 종료된 영화입니다.');
		location.href='playing';
	</script>
</c:if>

<c:if test="${!empty(movie)}">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
function reviewWrite() {
   var isLogin = false;
   <c:if test='${sMemberId!=null}'>
      isLogin = true;   
   </c:if>
   
   if (!isLogin) {
      alert('로그인 하세요');
      location.href = 'login';
   } else {
	  location.href='review_write?movieNo='+${movie.movieNo};
   }
}

function reviewRemove(reviewNo) {
	if (confirm("정말 삭제하시겠습니까?")) {
		document.f.action = "review_remove?reviewNo="+reviewNo;
		document.f.method = 'POST';
		document.f.submit();
	}  
	//location.href = "review_remove?reviewNo="+reviewNo;
}

function reviewModify(reviewNo) {
	location.href = "review_modify?reviewNo="+reviewNo;
}

$(function(){
	$('.ScreeningDate').on('click', function(e) {
		$(".ScreeningDate").css('background', 'white');
		$(e.target).css('background', 'green');
		$.ajax({
			url:'MovieTimeTableJSON?movieNo=${movie.movieNo}&movieDate=' + e.target.getAttribute("date"),
			method:'GET',
			dataType:'json',
			success:function(jsonObject) {
				var html='<ul>';
				html += `<li>
							<img src="\${jsonObject.posterImage}" width="21px" height="30px"/>
							(\${jsonObject.rating})\${jsonObject.title}
						</li>`;
				$.each(jsonObject.dateTimeTable, function(i, time) {
					html += `<li>
								<a href="booking?timeCode=\${time.timeCode}">
									\${time.screen.screenName}
									\${time.startTime} - \${time.endTime}
									잔여석 \${96 - time.bookedCount}석
								<a>
							</li>`;
				});
				html += '</ul>';
				
				$('#timeTableDiv').html(html);
			}
		});
		e.preventDefault();
	});
	
	$('.ScreeningDate:first').trigger('click');
});
</script>
</head>
<body> 
	<h1>영화정보</h1><hr>
	<ul>
		<li>movie_no: ${movie.movieNo}</li></br>
		<li>관람등급 : ${movie.rating}</li></br>
		<li>영화제목 : ${movie.title}</li></br>
		<li><img src="${movie.posterImage}" width="210px" height="300px"/></li>
		<li>개봉일 : <fmt:formatDate value="${movie.openDate}" pattern="yyyy-MM-dd" /></li></br>
		<li>감독 : ${movie.director}</li></br>
		<li>배우 : ${movie.actors}</li></br>
		<li>장르 : ${movie.genre}</li></br>
		<li>러닝타임 : ${movie.runningtime}</li></br>
		<li>평점 : <fmt:formatNumber value="${avgScore}" pattern=".0"/></li></br>
		<li>줄거리 : ${movie.summary}</li></br>
	</ul>
	<ul>
		<li>상영일자</li><br>
		<c:forEach items="${dateList}" var="date">
			<li>
				<%-- <a class="ScreeningDate" href="MovieTimeTableJSON?movieNo=${movie.movieNo}&movieDate=${date}"> --%>
				<a class="ScreeningDate" href="#;" date="${date}">
					<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
				</a>
			</li>
			</br>
		</c:forEach>
	</ul>
	<div id="timeTableDiv">이곳이 타임테이블</div>
	<form name="f">
		<ul>	
			<li>리뷰</li><br>
			<c:forEach items="${movie.reviewList}" var="review">
				<li>
					평점[${review.score}] ${review.reviewComment} (${review.member.name})
					<c:if test="${review.member.id eq sMemberId}">
						<input type="button" onclick="reviewModify(${review.reviewNo});" value="리뷰 수정"/>
						<input type="button" onclick="reviewRemove(${review.reviewNo});" value="리뷰 삭제"/>
					</c:if>
				</li>
				<br>
			</c:forEach>
		</ul>
	</form>

	<input type="button" onclick="reviewWrite();" value="리뷰작성"/>

</body>
</html>
</c:if>