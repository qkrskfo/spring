


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<!-- 
	<ul>
		<c:forEach items="${timeList}" var="time">
			<li><img src="${time.movie.posterImage}" width=150 height=150/></li>		
			<li>${time.movie.rating} &nbsp;<b>${time.movie.title}</b></li>
			<li>${time.screen.screenName}</li>		
			<li>${time.startTime}</li>
			<hr/>
		</c:forEach>
	</ul>
 -->
 <form id="timeTablePage">
	<div class="btn-group-vertical btn-group-toggle" data-toggle="buttons">
		<table>
			<c:forEach items="${timeList}" var="time" varStatus="status">
				<tr id="accuracyTime_${time.movie.title}_${time.movie.rating}_${status.index}">
					<td id="title_${time.movie.title}_${status.index}"> ${time.movie.title}</td>
					<td id="posterimage_${time.movie.title}_${status.index}"><img src="${time.movie.posterImage}" width=200 height=200 /></td>
					<td id="rating_${time.movie.title}_${time.movie.rating}_${status.index}"> ${time.movie.rating}</td>
					<td>${time.screen.screenName}</td>
					<td>${time.startTime}</td>
				</tr>
			</c:forEach>
		</table>
	</div> 
 </form>
 
 <script type="text/javascript">
 	//$("#timeTablePage .btn.btn-outline-primary:first").addClass("active");
 	function getUniqueTitle() {
 		var uniqueTitle = [];
 		$('td[id^="requestTitle_"]').each(function(i, data) {
 			var requestTitle = ${data}.text();
 			if($.inArray(requestTitle, uniqueTitle) === -1) uniqueTitle.push(requestTitle);
 		});
 	};
 	
 	var uniqueTitle = getUniqueTitle();
 	$.each(uniqueTitle, function(i, title) {
 		
 		var $requestTitles = $('td[id^="title_'+title+'"]');
 		$requestTitles.not(":first").remove();
 		$requestTitles.attr("rowspan", $requestTitles.size());
 		
 		var $requestPosterimages = $('td[id^="posterimage_'+title+'"]');
 		$requestPosterimages.not(":first").remove();
 		$requestPosterimages.attr("rowspan", $requestPosterimages.size());
 		
 		var ratingSize = ${fn:length(ratingList)};
 		for (var j=0; j<=ratingSize; j++) {
 			var $requestRatings = $('td[id^="requestRatings_'+title+'_'+j+'"]');
 			$requestRatings.not(":first").remove();
 			$requestRatings.attr("rowspan", $requestRatings.size());
 		}
 	})
 	
 	
 </script>
</body>
</html>