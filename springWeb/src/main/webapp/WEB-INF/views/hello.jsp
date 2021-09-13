<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>hello.jsp</h1><hr>
<ol>
	<li>/hello.do요청</li>
	<li>
		DispatcherServlet이 HandlerMapping객체로부터 요청url[/hello.do]에 해당하는 
	    HelloController객체얻기
	 </li>
	 <li>
	 	DispatcherServlet이 HelloController객체의 HandleRequest메쏘드 호출	
	 </li> 
	 <li>
	 	DispatcherServlet이 HelloController객체의 HandleRequest메쏘드 호출후 
	 	반환된 forwardPath로 forwarding..
	 </li>  
	 <li>
	 	/WEB-INF/views/hello.jsp 응답
	 </li>
	 
	 <li>Controller객체에서 요청객체에 설정된 속성객체출력:${hello.msg}</li>
</ol>
</body>
</html>