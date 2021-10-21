<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if IE 7 ]> <html lang="ko" class="ie7"> <![endif]-->
<!--[if IE 8 ]> <html lang="ko" class="ie8"> <![endif]-->
<!--[if IE 9 ]> <html lang="ko" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="ko">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="author" content="CJ O Shopping" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>에러페이지 :: CJO</title>
<link rel="stylesheet" type="text/css"
	href="//image.cjonstyle.net/public/confirm/contents/common/error/css/bi_error.css">
<style type="text/css">
.no_target_wrap .no_target {
	width: 310px;
	left: 50%;
	margin: -115px 0 0 -255px
}
</style>
</head>
<body>
	<div id="wrap">
		<!-- container -->
		<div id="container">

			<!-- content -->
			<div id="content">

				<!-- 타겟 URL없음-->
				<div class="no_target_wrap">
					<div class="no_target">
						<div class="spinner">로딩중</div>
						<p>요청한 페이지를 찾을 수 없습니다.</p>
						<div class="btn_wrap">
							<div>
								<button type="button" class="u_btn home"
									onclick="history.back()">이전 페이지</button>
							</div>
							<div>
								<button type="button" class="u_btn" onclick="gotoHome()">홈으로
									이동</button>
							</div>
						</div>
						<div class="error_contact_info">
							<ul class="info_list">
								<li class="email"><strong class="title">이메일</strong><span
									class="cont">webmaster@itwill.com</span></li>
								<li class="cs"><strong class="title">고객센터</strong><span
									class="cont">123-4545</span></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- //타겟 URL없음-->

			</div>
			<!-- //content -->

		</div>
		<!-- //container -->

	</div>
	<script type="text/javascript">
		function gotoHome() {
			window.location = "shop_main";
			return;
		}
	</script>

</body>
</html>
