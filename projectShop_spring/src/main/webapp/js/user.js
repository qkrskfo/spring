/**
 * 
 */
 function user_modify_form_myinfo() {
		document.f.action = "user_modify_form_myinfo";
		document.f.method = "POST";
		document.f.submit();
}
function user_modify_action() {
		document.f.action = "user_modify_action_myinfo";
		document.f.method='POST';
		document.f.submit();
	}
function user_remove_action_myinfo() {
	if (confirm("정말 삭제하시겠습니까?")) {
		document.f.action = "user_remove_action_myinfo";
		document.f.method = 'POST';
		document.f.submit();
	}
}
function user_write_form() {
		document.f.action = "user_write_form";
		document.f.submit();
}
function user_login_action() {
	if (document.f.userId.value == "") {
		alert("사용자 아이디를 입력하십시요.");
		document.f.userId.focus();
		return false;
	}
	if (document.f.password.value == "") {
		alert("비밀번호를 입력하십시요.");
		document.f.password.focus();
		return false;
	}

	document.f.action = "user_login_action";
	document.f.submit();
}
function user_write_action() {
		if (document.f.userId.value == "") {
			alert("사용자 아이디를 입력하십시요.");
			document.f.userId.focus();
			return false;
		}
		if (document.f.password.value == "") {
			alert("비밀번호를 입력하십시요.");
			document.f.password.focus();
			return false;
		}
		if (document.f.password2.value == "") {
			alert("비밀번호확인을 입력하십시요.");
			document.f.password2.focus();
			return false;
		}
		if (document.f.name.value == "") {
			alert("이름을 입력하십시요.");
			document.f.name.focus();
			return false;
		}
		if (document.f.email.value == "") {
			alert("이메일 주소를 입력하십시요.");
			document.f.email.focus();
			return false;
		}
		if (document.f.password.value != document.f.password2.value) {
			alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
			document.f.password.focus();
			document.f.password.select();
			return false;
		}
		document.f.action = "user_write_action";
		document.f.method='POST';
		document.f.submit();
}

function shop_main() {
		location.href = "shop_main";
}