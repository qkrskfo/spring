function login() {
	if (loginform.id.value == "") {
		alert("아이디를 입력하세요.");
		loginform.id.focus();
		return false;
	}

	if (loginform.password.value == "") {
		alert("비밀번호를 입력하세요.");
		loginform.password.focus();
		return false;
		}

	loginform.action = "login_action";
	loginform.submit();
}

function signup(){
	document.signup_form.action='signup_action';
	document.signup_form.method='POST';
	document.signup_form.submit();
}


