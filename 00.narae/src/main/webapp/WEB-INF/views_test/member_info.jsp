<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>내정보</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function member_modify() {
		document.f.action = "member_modify";
		document.f.method = "POST";
		document.f.submit();
	}
	
	function member_remove_action() {
		if (confirm("정말 삭제하시겠습니까?")) {
			document.f.action = "member_remove_action";
			document.f.method = 'POST';
			document.f.submit();
		}
	}
</script>
</head>
<body>
	<div id="container">
		<div id="wrapper">
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td><b>내정보</b></td>
								</tr>
							</table>
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											${loginMember.id}</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											${loginMember.name}</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">핸드폰</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											${loginMember.phone}</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">생년월일</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
										<s:eval expression="new java.text.SimpleDateFormat('yyyy-MM-dd').format(loginMember.birth_date)"></s:eval>
											</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center><input type="button" value="내정보수정"
										onClick="member_modify()">&nbsp; 
										<input type="button" value="탈퇴" onClick="member_remove_action()">&nbsp;</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>