<<< 모델2 작성방법 >>

	A. DispatcherServlet[Controller서블릿]작성
	
	B. 단일 서블릿이 모든클라이언트요청에의해 실행하도록 web.xml설정
	
	    - web.xml
	
			- dispatcher com.itwill.summer.DispatcherServlet 1 dispatcher *.do
			
				<servlet>
					<servlet-name>dispatcher</servlet-name>
					<servlet-class>com.itwill.summer.controller.DispatcherServlet</servlet-class>
					<load-on-startup>1</load-on-startup>
				</servlet>
				<servlet-mapping>
					<servlet-name>dispatcher</servlet-name>
					<url-pattern>*.do</url-pattern>
					<!-- 
					<url-pattern>/member_main.do</url-pattern>
					<url-pattern>/member_detail.do</url-pattern>
					<url-pattern>/member_list.do</url-pattern>
					 -->
				</servlet-mapping>

			
	C. 인코딩필터클래스설정 web.xml설정
	
		<filter>
			<filter-name>encoding filter</filter-name>
			<filter-class>com.itwill.filter.EncodingFilter</filter-class>
			<init-param>
				<param-name>encoding</param-name>
				<param-value>UTF-8</param-value>
			</init-param>
		</filter>
		<filter-mapping>
			<filter-name>encoding filter</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>