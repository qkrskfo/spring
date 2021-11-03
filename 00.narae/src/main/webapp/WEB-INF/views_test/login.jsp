<!DOCTYPE html>
<html lang="en" >
<head>
	<meta charset="UTF-8">
	<title>CodePen - Log In / Sign Up - pure css - #12</title>
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css' rel="stylesheet" type="text/css">
	<link rel='stylesheet' href='https://unicons.iconscout.com/release/v2.1.9/css/unicons.css' rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="./css/login-style.css" rel="stylesheet" type="text/css">
	<!-- JS -->
	<script type="text/javascript">
	function login() {
		if (f.id.value == "") {
			alert("아이디를 입력하세요.");
			f.id.focus();
			return false;
		}

		if (f.password.value == "") {
			alert("비밀번호를 입력하세요.");
			f.password.focus();
			return false;
		}

		f.action = "login_action";
		f.submit();
	}
</script>
</head>
<body>
	<div class="section">
		<div class="container">
			<div class="row full-height justify-content-center">
				<div class="col-12 text-center align-self-center py-5">
					<div class="section pb-5 pt-5 pt-sm-2 text-center">
						<h6 class="mb-0 pb-3"><span>Log In </span><span>Sign Up</span></h6>
			          	<input class="checkbox" type="checkbox" id="reg-log" name="reg-log"/>
			          	<label for="reg-log"></label>
						<div class="card-3d-wrap mx-auto">
							<div class="card-3d-wrapper">
							<!-- 로그인 -->
								<div class="card-front">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3">Log In</h4>
											<form name="f" method = "post">
											<div class="form-group">
												<input type="text" name="id" value="${fmember.id}" class="form-style" placeholder="Your Id" id="logemail" autocomplete="off">
												<i class="input-icon uil uil-at"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="password" name="password" value="${fmember.password}" class="form-style" placeholder="Your Password" id="logpass" autocomplete="off">
												<i class="input-icon uil uil-lock-alt"></i>
											</div>
											<input type="button" class="btn mt-4" value="submit" onclick="login();">
                            				<p class="mb-0 mt-4 text-center"><a href="#0" class="link">Forgot your password?</a></p>
                            				</form>
				      					</div>
			      					</div>
			      				</div>
			      				<!-- 회원가입 -->
								<div class="card-back">
									<div class="center-wrap">
										<div class="section text-center">
											<h4 class="mb-4 pb-3">Sign Up</h4>
											<div class="form-group">
												<input type="text" name="logname" class="form-style" placeholder="Your Full Name" id="logname" autocomplete="off">
												<i class="input-icon uil uil-user"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="email" name="logemail" class="form-style" placeholder="Your Email" id="logemail" autocomplete="off">
												<i class="input-icon uil uil-at"></i>
											</div>	
											<div class="form-group mt-2">
												<input type="password" name="logpass" class="form-style" placeholder="Your Password" id="logpass" autocomplete="off">
												<i class="input-icon uil uil-lock-alt"></i>
											</div>
											<a href="#" class="btn mt-4">submit</a>
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
  <script  src="./script.js"></script>

</body>
</html>
