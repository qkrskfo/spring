<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>WELCOME TO JQUERY</title>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet" href="guest.css" type="text/css" media="screen" />
<style type="text/css">
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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.3/dist/jquery.validate.js"></script>
<script type="text/javascript">
	/*****browser locale[navigator.language] 에따른message 동적설정***/
</script>
<script type="text/javascript">
	
	$(function() {
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%메뉴 UI이벤트처리시작[DOM트리로딩후]%%%%%%%%%%%%%%%%%%%%%%%%%*/
		/**방명록리스트[html]이벤트처리**/
		$('#menu-a a').click(function(e){
			//ajax요청
			$.ajax({
				url:'guest/guest_list_html',
				method:'GET',
				dataType:'html',
				success:function(html){
					$('#guest_list').html(html);
				}
			});
			e.preventDefault();
		});
		/**방명록리스트[JSON]이벤트처리**/
		$('#menu-b a').click(function(e){
			//ajax요청
			$.ajax({
				url:'guest/guest_list_json',
				method:'GET',
				dataType: "json",
				success:function(jsonArray){
					/*
					<div class="guest_item">
						<h3 class="guest_title"  guest_no="1"><a href="">방명록 사용법1[HTML]</a></h3>
					</div>
					*/
					var html='';
					$.each(jsonArray,function(i,guest){
						/**************
						html+=`
							<div class="guest_item">
							<h3 class="guest_title"  guest_no="${guest.guest_no}"><a href="">${guest.guest_title}[JSON]</a></h3>
							</div>
						`;
						****************/
						html += "<div class='guest_item'>";
						html += "<h3 class='guest_title'  guest_no='"+guest.guest_no+"'><a href=''>"
								+ guest.guest_title
								+ "[JSON]</a></h3>";
						html += "</div>";
						
					});
					$('#guest_list').html(html);
					
				}
			});
			e.preventDefault();
		});
		/**방명록리스트[XML]이벤트처리***/
		$('#menu-c a').click(function(e){
			//ajax요청
			$.ajax({
				url:'guest/guest_list_xml',
				method:'GET',
				dataType: "xml",
				success: function(xmlDocument){
					/*
					<guest_list>
						<guest>
							<guest_no>1</guest_no>
							<guest_name>김경가</guest_name>
							<guest_date>2021-10-01 14:31:31</guest_date>
						</guest>
						<guest>..</guest>
						..
					</guest_list>
					*/
					var html='';
					$(xmlDocument).find('guest').each(function(i,guestElement){
						/*
						<div class="guest_item">
							<h3 class="guest_title"  guest_no="1"><a href="">방명록 사용법1[HTML]</a></h3>
						</div>
						*/
						var guest_no=$(guestElement).find('guest_no').text();
						var guest_title=$(guestElement).find('guest_title').text();
						html+=`
							<div class="guest_item">
								<h3 class="guest_title"  guest_no="${guest_no}"><a href="">${guest_title}[XML]</a></h3>
							</div>
						`;
					});
					$('#guest_list').html(html);	
				}
			});
			e.preventDefault();
		});
		/**방명록쓰기폼로드 이벤트처리******/
		$('#menu-d a').click(function(e){
			//ajax요청
			$.ajax({
				url:'guest_insert_form.html',
				method:'GET',
				success:function(responseHtml){
					$('#guest_list').html(responseHtml);
				}
			});
			e.preventDefault();
		});
		
		/**방명록쓰기이벤트처리[동적이벤트처리]******/
		//현재DOM Tree에 동적이벤트추가에는 항상 상위엘레멘트의 참조가필요
		/*
		$('#guest_list').on('submit','#guest_write_form',function(e){
			alert('submit!!!');
			//유효성체크후 통과하면 submit요청
			
			$.ajax({
				url:'guest/guest_insert_action.jsp',
				method:'POST',
				data:$(e.target).serialize(),
				dataType: "text",
				success:function(resultText){
					if(resultText.trim()=='true'){
						//alert('성공');
						//리스트보여주기(이벤트 강제로 발생시키기)
						$('#menu-a a').trigger('click');
					}else if(resultText.trim()=='false'){
						alert('실패');
						
					}			
				}
			});
			
			e.preventDefault();
		});
		*/
		
		/**방명록쓰기이벤트처리[form validator plugin]******/
		/************form validator**************
		HOMEPAGE :   https://jqueryvalidation.org/
	    API      :   https://jqueryvalidation.org/validate/
		    1. $(form).validate() function은 DOM tree loading시에 미리 호출되어있어야한다.
		    2. $(form).validate() function은 DOM tree insert[DOMNodeInserted 이벤트] 될때 미리 호출되어있어야한다.
		*****************************************/
		$('#guest_list').on('DOMNodeInserted','#guest_write_form',function(){
			console.log("#guest_write_form 이 #guest_list자식으로 DOMNodeInserted 될때호출");
			$('#guest_write_form').validate({
				rules:{
					guest_name:{
						required:true,
						minlength: 3,
						maxlength: 10
					},
					guest_title:{
						required: true
					},
					guest_content:{
						required: true
					},
					guest_homepage:{
						required: true,
						url:true
					},
					guest_email:{
						required: true,
						email:true
					}
					
				},
				messages:{
					guest_name:{
						required: "이름을 입력하세요",
						minlength: "이름은 {0} 글자이상입니다.",
						maxlength: "이름은 {0} 글자이하입니다."
					},
					guest_title:{
						required: "제목을 입력하세요"
					},
					guest_content:{
						required: "내용을 입력해주세요"
					},
					guest_homepage:{
						required: "홈페이지를 입력해주세요",
						url:'홈페이지 형식이틀렸어요'
					},
					guest_email:{
						required: "이메일을 입력해 주세요",
						email:'이메일 형식이틀렸어요'
					}
				},
				errorClass:'error',
				validClass:'valid',
				submitHandler:function(f){
					/*
					form의 submit을 클릭하면 유효성체크하고 유효성을 통과하면 함수호출
					*/
					$.ajax({
						url:'guest/guest_insert_action',
						method:'POST',
						data:$(f).serialize(),
						dataType: "text",
						success:function(resultText){
							if(resultText.trim()=='true'){
								//alert('성공');
								//리스트보여주기(이벤트 강제로 발생시키기)
								$('#menu-a a').trigger('click');
							}else if(resultText.trim()=='false'){
								alert('실패');
								
							}			
						}
					});
				}
				
			});
			//end validate
			
		});//end DOMNodeInserted event
		
		
		/**방명록상세보기이벤트처리[동적이벤트처리]******/
		//현재DOM Tree에 동적이벤트추가에는 항상 상위엘레멘트의 참조가필요
		/*
		<div id="guest_list">
			<div class="guest_item">
				<h3 class="guest_title" guest_no="1"><a href="">방명록 사용법1[HTML]</a></h3>
			</div>
		</div>	
		*/
		$('#guest_list').on('click','.guest_title a',function(e){
			var titleStr = $(e.target).text();
			var h3Element=e.target.parentElement;
			var params = 'guest_no='+$(h3Element).attr('guest_no');
			
			if(titleStr.endsWith('[HTML]')){
				/************방명록상세보기[HTML]*********************/
				if($(h3Element).parent().children().length > 1){
					//상세정보 존재
					$(h3Element).next().slideToggle(500);
				}else{
					//상세정보 존재	안함(ajax요청)
					$.ajax({
						url:'guest/guest_detail_html',
						data:params,
						method:'GET',
						dataType: "html",
						success:function(htmlData){
							$("<div class='guest_detail' style='display:none'></div>").html(htmlData).insertAfter(h3Element);
							$(h3Element).next().slideToggle(500);
						}
					});
				}
				
				
			}else if(titleStr.endsWith('[JSON]')){
				/************방명록상세보기[JSON]*********************/
				/*
				<< guest_detail 받은데이타>>
				[
					{
					"guest_no": "1",
					"guest_name": "김경가",
					"guest_date": "2021-10-01 14:31:31",
					"guest_email": "guard1@naver.com",
					"guest_title": "방명록 사용법1",
					"guest_content": "방명록처럼 사용하시면 됩니다1"
					}
				]
				 
				<<보여줘여할 HTML>>
					<div class="guest_item">
						<h3 class="guest_title" guest_no="1"><a href="">방명록 사용법1[JSON]</a></h3>
						<div class='guest_detail' style='display:block'>
							<div class="guest_date">날짜:2021-10-01 14:31:31</div>
							<div class="guest_name">이름:김경가	</div>
							<div class="guest_email">이메일:guard1@naver.com</div>
							...
						</div>
					</div>	
					*/
			}else if(titleStr.endsWith('XML')){
				/************방명록상세보기[XML]*********************/
				/*
				<< guest_detail 받은데이타>>
				<guest_list>
					<guest>
						<guest_no>1</guest_no>
						<guest_name>김경가</guest_name>
						<guest_date>2021-10-01 14:31:31</guest_date>
						<guest_email>guard1@naver.com</guest_email>
						<guest_homepage>http://www.naver.com</guest_homepage>
						<guest_title>방명록 사용법1</guest_title>
						<guest_content>방명록처럼 사용하시면 됩니다1</guest_content>
					</guest>
				</guest_list>
				   
				<<보여줘여할 HTML>>
					<div class="guest_item">
						<h3 class="guest_title" guest_no="1"><a href="">방명록 사용법1[XML]</a></h3>
						<div class='guest_detail' style='display:block'>
							<div class="guest_date">날짜:2021-10-01 14:31:31</div>
							<div class="guest_name">이름:김경가	</div>
							<div class="guest_email">이메일:guard1@naver.com</div>
							...
						</div>
					</div>	
					*/
			}
			e.preventDefault();
		});
		
		/**방명록삭제[수정]이벤트처리[동적이벤트처리]******/
		//현재DOM Tree에 동적이벤트추가에는 항상 상위엘레멘트의 참조가필요
		/*
		<div class="guest_detail" style="">
			..
			<div class="guest_delete">
				<input type="button" value="삭제" guest_no="1">
				<input type="button" value="수정" guest_no="1">
			</div>
		</div>	
		*/
		$('#guest_list').on('click',".guest_delete input[value='삭제']",function(e){
			alert('삭제:'+$(e.target).attr('guest_no'));
		});		
		$('#guest_list').on('click',".guest_delete input[value='수정']",function(e){
			alert('수정폼:'+$(e.target).attr('guest_no'));
		});		
		
		
		/****************jQuery ajax global event handler************/
		/*
		<<< jQuery factory function에 들어갈수있는인자>>>
			1 . $('#id')   		: css selector문자열
			2 . $(document)		: 표준객체
			3 . $(function(){})	: 함수
			4 . $('<div></div>'): 태그문자열
		    	div element jQuery wrapper객체생성
		 */
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%메뉴 UI이벤트처리시작[DOM트리로딩후]%%%%%%%%%%%%%%%%%%%%%%%%%*/
	
	/*%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% jQuery Ajax Gloaba event %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%*/
	$(document).ajaxStart(function(){
		//progress dialog show
		/***********jquery 팩토리function을 이용한 jQuery wraper element(tag)객체 생성*********/
		$("<div id='loading'>loading...</div>").insertBefore('#guest_list').show();
		
		
	});
	$(document).ajaxComplete(function(){
		//progress dialog hide
		$('#loading').hide();
		$('#loading').remove();
	});		
	
	
	
	
	
	});
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>WELCOME TO JQUERY</h1>
		</div>
		<div id="sidebar">
			<h2>방명록메뉴</h2>
			<div class="menus">
				<div class="menu" id="menu-a">
					<h3>
						<a href="test.jsp">방명록 리스트[html]</a>
					</h3>
				</div>
				<div class="menu" id="menu-b">
					<h3>
						<a href="#">방명록 리스트[json]</a>
					</h3>
				</div>
				<div class="menu" id="menu-c">
					<h3>
						<a href="#">방명록 리스트[xml]</a>
					</h3>
				</div>
				<div class="menu" id="menu-d">
					<h3>
						<a href="#">방명록 쓰기폼</a>
					</h3>
				</div>
				<!-- 
				<div class="menu" id="menu-e">
					<h3>
						<a href="#">json</a>
					</h3>
				</div>
				<div class="menu" id="menu-f">
					<h3>
						<a href="#">xml</a>
					</h3>
				</div>
				
				<form id="guest_login_form" method="get" action="vfbfcv">
					<fieldset>
						<legend>로그인</legend>
						<p>
							<label for="guest_id">아이디:</label> <input type="text"
								placeholder="아이디" id="guest_id" name="guest_id" />
						</p>
						<p>
							<label for="guest_pass">패쓰워드:</label> <input type="text"
								placeholder="패쓰워드" name="guest_pass" id="guest_pass" />
						</p>
						<p>
							<input type="submit" name="write" value="로그인" id="write" /> <input
								type="reset" name="cancle" value="취소" id="cancle" />
						</p>
						<div id="msg"></div>
					</fieldset>
				</form>
				<form id="guest_logout_form">
					<div>
						<span id="idSpan"></span>님 로그인<br /> <a href='#'>로그아웃</a>
					</div>
				</form>
				-->
			</div>
		</div>
		<div id="content">
			<div id="guest_list"></div>
		</div>
		<div id="footer">
			<p>This page was built for jquery demonstration purposes.</p>
		</div>

	</div>

</body>
</html>