<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>내정보 수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function member_modify_action() {
		document.f.action = "member_modify_action";
		document.f.method = 'POST';
		document.f.submit();
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
									<td><b>내정보수정</b></td>
								</tr>
							</table>
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left">${loginMember.id}</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="password" style="width: 150px"
											name="password" value=""></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호
											확인</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="password" style="width: 150px"
											name="password2" value=""></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="name" value="${loginMember.name}"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											핸드폰</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="phone" value="${loginMember.phone}"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">생년월일</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left">
											<input type="text" style="width: 300px" name="birth_date" value="<s:eval expression="new java.text.SimpleDateFormat('yyyy/MM/dd').format(loginMember.birth_date)"></s:eval>">
											</td>



									</tr>
								</table>
							</form> <br>

							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="내정보수정"
										onClick="member_modify_action();"> &nbsp;</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>