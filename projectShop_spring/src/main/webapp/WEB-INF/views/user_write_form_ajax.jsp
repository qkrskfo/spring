<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<style type="text/css" media="screen">
input.error, textarea.error {
	border: 1px solid red;
}
label.error {
	margin-left: 10px;
	color: orange;
}
.valid {
	border: 1px solid green;
}
</style>
<!-- jquery , jquery-validation -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>

<script type="text/javascript">
	$(function() {
		/*##########회원가입,메인버튼 이벤트처리#############*/
		$('#member_create_btn').click(function(e) {
			$('#f').trigger('submit');
		});
		$('#shop_main_btn').click(function(e) {
			location.href = 'shop_main';
		});
		/************form validator**************
		HOMEPAGE :   https://jqueryvalidation.org/
	    API      :   https://jqueryvalidation.org/validate/
		*****************************************/
		$('#f').validate({
			rules : {
				userId : {
					required : true,
					remote: {
				        url: "user_id_duplicate_check_rest",
				        type: "GET",
				        data: {
				          userId: function() {
				            return $( "#userId" ).val();
				          }
				        }
				     }
				},
				password : {
					required : true
				},
				password2 : {
					required : true,
					equalTo: "#password"
				},
				name : {
					required : true,
				},
				email : {
					required : true,
					email : true
				}
			},
			messages : {
				userId : {
					required : "아이디를 입력하세요",
					remote:"{0} 은 이미사용중인 아이디입니다." 
				},
				password : {
					required : "비밀번호를 입력하세요"
				},
				password2 : {
					required : "비밀번호확인을 입력해주세요",
					equalTo: "비밀번호와 비밀번호확인은 일치하여야합니다."
				},
				name : {
					required : "이름을 입력해주세요"
				},
				email : {
					required : "이메일을 입력해 주세요",
					email : '이메일 형식에 맞게 입력해주세요'
				}
			},
			errorClass : 'error',
			validClass : 'valid',
			submitHandler : function(f) {
				//form의 submit을 클릭하면 유효성체크하고 유효성을 통과하면 함수호출
				f.action='user_write_action';
				f.method='POST';
				f.submit();
			}
		});
	});
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" /> 
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" /> 
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table width=0 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 회원 가입[jQuery Ajax]</b></td>
								</tr>
							</table> <!-- write Form  -->
							<form name="f" id="f">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="userId" id="userId">&nbsp;&nbsp; <font
											color="red"></font></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="password" style="width: 150px"
											name="password" id="password" value=""></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호
											확인</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="password" style="width: 150px"
											name="password2" value="" id="password2"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="name" id="name" value=""></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="email" id="email" value=""></td>
									</tr>
								</table>
							</form> <br />

							<table border=0 cellpadding=0 cellspacing=1>
								<tr>
									<td align=center><input id="member_create_btn" type="button" value="회원 가입"> &nbsp; <input
										id="shop_main_btn" type="button" value="메인"></td>
								</tr>
							</table>

						</td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>