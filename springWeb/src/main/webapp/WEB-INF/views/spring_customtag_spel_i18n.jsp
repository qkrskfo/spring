<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
	<li><s:message code="page.title" /></li>
	<li><s:message code="page.login.header"/></li>
	<!-- 
		<< user_ko.properties>>
		exception.userexisted={0} 사용자가 존재합니다..!!
		<< user_en.properties>>
		exception.userexisted = {0} user existed...!!
	 -->
	<li><s:message code="exception.userexisted" arguments="guard" /></li> <!-- arguments에 el 들어갈 수 있음 -->
	<li><s:message code="exception.userexisted" arguments="xxxx" /></li>
	<li></li> 
	<!-- 
	<< user_ko.properties >>
	nv.bc=홈 < {0} < {1}
	<< user_en.properties >>
	nv.bc=HOME < {0} < {1}
	 -->
	 <li><s:message code="nv.bc" arguments="유저, 유저리스트" argumentSeparator="," /></li> 
	 <li><s:message code="nv.bc" arguments="USER, USER LIST" argumentSeparator="," /></li> 
	 
	 <li></li>
	 <li></li> 
	 <li>
	 <li>Controller에서 생성한 메세지:${user_existed_exception_controller_msg}</li>
	 <li>Service에서 생성한 메세지:${user_existed_exception_service_msg}</li>
</ol>

</body>
</html>