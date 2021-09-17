<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring I18N[Internationalization]국제화</h1><hr>
<xmp>
	1. application-config.xml에 MessageSource빈설정
	 <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
    	<property name="basenames" value="messages/guest,messages/messages,messages/user"/>
    </bean>
</xmp>
<ol>
	<li></li>
	<li></li>
	<!-- 
		exception.userexisted={0} 사용자가 존재합니다..!!
	 -->
	<li></li>
	<li></li> 
	<!-- 
	nv.bc=홈 < {0} < {1}
	nv.bc=HOME < {0} < {1}
	 -->
	 <li></li> 
	 
	 <li></li>
	 <li></li> 
	 <li>
	 <li>Controller에서 생성한 메세지:${user_existed_exception_controller_msg}</li>
	 <li>Service에서 생성한 메세지:${user_existed_exception_service_msg}</li>
</ol>

</body>
</html>