<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function payAction() {
		f.action = "pay_action";
		alert("결제 성공");
		f.submit();
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>결제수단</h1>
		카드(번호입력)<input type="radio" name="결제" value="카드(번호입력)">
		카드(간편결제)<input type="radio" name="결제" value="카드(간편결제)">
		카카오페이<input type="radio" name="결제" value="카카오페이">
		페이코<input type="radio" name="결제" value="페이코">
<form name="f" method ="post">
<input type="button" value="결제하기" onclick="payAction()">
</form>
</body>
</html>