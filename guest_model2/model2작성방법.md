<<< ��2 �ۼ���� >>

	A. DispatcherServlet[Controller����]�ۼ�
	
	B. ���� ������ ���Ŭ���̾�Ʈ��û������ �����ϵ��� web.xml����
	
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

			
	C. ���ڵ�����Ŭ�������� web.xml����
	
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