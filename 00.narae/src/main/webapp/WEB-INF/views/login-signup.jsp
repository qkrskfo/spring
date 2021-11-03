<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8">
	<title>Little Cinema - Log In / Sign Up </title>
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css' rel="stylesheet" type="text/css">
	<link rel='stylesheet' href='https://unicons.iconscout.com/release/v2.1.9/css/unicons.css' rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="./css/login-style.css" rel="stylesheet" type="text/css">
	<script src="js/login-signup.js"></script>
</head>
<body>
	<div class="section">
		<div class="container">
			<div class="row full-height justify-content-center">
				<div class="col-12 text-center align-self-center py-5">
					<div class="section pb-5 pt-5 pt-sm-2 text-center">
						<h6 class="mb-0 pb-3"><span>로그인</span><span>회원가입</span></h6>
			          	<input class="checkbox" type="checkbox" id="reg-log" name="reg-log"/>
			          	<label for="reg-log"></label>
						<div class="card-3d-wrap mx-auto">
							<div class="card-3d-wrapper">
							<!-- 로그인 -->
								<div class="card-front">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3">로그인</h4>
											<form name="loginform" method = "post">
											<div class="form-group">
												<input type="text" name="id" value="${fmember.id}" class="form-style" placeholder="아이디" id="logemail" autocomplete="off">
												<i class="input-icon uil uil-at"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="password" name="password" value="${fmember.password}" class="form-style" placeholder="비밀번호" id="logpass" autocomplete="off">
												<i class="input-icon uil uil-lock-alt"></i>
											</div>
											<input type="button" class="btn mt-4" value="submit" onclick="login();">
                            				</form>
				      					</div>
			      					</div>
			      				</div>

			      				<!-- 회원가입 -->
								<div class="card-back">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3">회원가입</h4>
											<form id="signup_form" name="signup_form">
											<div class="form-group">
												<input type="text" name="id" value="" class="form-style" placeholder="아이디" id="uid" autocomplete="off">
												<i class="input-icon uil uil-at"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="password" name="password" value="" class="form-style" placeholder="비밀번호" id="upassword" autocomplete="off">
												<i class="input-icon uil uil-lock-alt"></i>
											</div>
											<div class="form-group mt-2">
												<input type="text" name="name" value="" class="form-style" placeholder="이름" id="name" autocomplete="off">
												<i class="input-icon uil uil-user"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="text" name="phone" value="" class="form-style" placeholder="전화번호" id="phone" autocomplete="off">
												<i class="input-icon uil uil-user"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="text" name="birth_date" value="" class="form-style" placeholder="생일" id="birth_date" autocomplete="off">
												<i class="input-icon uil uil-user"></i>
											</div>	
											<input id="member_add_btn" type="button" class="btn mt-4" value="회원가입" onclick="signup();">
											</form>
				      					</div>
			      					</div>
			      				</div>
			      			</div>
			      		</div>
			      	</div>
		      	</div>
	      	</div>
	    </div>
	</div>
<!-- partial -->
  <script  src="js/jquery-3.5.1.min.js"></script>
  <script  src="js/script.js"></script>

</body>
</html>
