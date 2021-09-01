package com.itwill.summer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

/*
 * 클라이언트의 모든요청(*.do)을 받는 서블릿(Controller)
 */
public class DispatcherServlet extends HttpServlet {
	/*
	 * Controller객체들을 저장하는맵
	 */
	private HashMap<String,Controller> controllerMap;
	
	public DispatcherServlet() {
		System.out.println("0.DispatcherServlet()생성자");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("0.DispatcherServlet.init()");
		super.init(config);
		controllerMap=new HashMap<String, Controller>();
		/*
		<< web.xml에 설정된 파라메타값 가져오기 >>
		<servlet>
		  	<servlet-name>dispatcher</servlet-name>
		  	<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
		  	<init-param>
		  		<param-name>configFile</param-name>
		  		<param-value>/WEB-INF/guest_controller_mapping.properties</param-value>
		  	</init-param>
  		</servlet>
		 */
		//String configFile="/WEB-INF/guest_controller_mapping.properties";
		String configFile=config.getInitParameter("configFile");
		ServletContext servletContext=this.getServletContext();
		String configFileRealPath = servletContext.getRealPath(configFile);
		try {
			FileInputStream in=new FileInputStream(configFileRealPath);
			Properties controllerMappingProperties=new Properties();
			controllerMappingProperties.load(in);
			System.out.println("-----------------------"+configFile+"----------------------------");
			Set commandKeySet=controllerMappingProperties.keySet();
			Iterator commandKeyIterator = commandKeySet.iterator();
			while(commandKeyIterator.hasNext()) {
				String command = (String)commandKeyIterator.next();
				String controllerClassName=controllerMappingProperties.getProperty(command);
				/*
				 * Controller클래스로딩
				 */
				Class controllerClass = Class.forName(controllerClassName);
				/*
				 *  Controller클래스기본생성자호출
				 */
				Controller controllerObject =(Controller)controllerClass.newInstance();
				controllerMap.put(command, controllerObject);
				System.out.println(command+"="+controllerObject);
			}
			System.out.println("-------------------------------------------------------------------");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 1.클라이언트 요청URI를 사용해서 요청분석
		 */
		String command=request.getRequestURI().substring(request.getContextPath().length());
		
		/*
		 * 2-1.클라이언트요청에따른 업무실행 Controller객체를 command키로 얻기
		 */
		String forwardPath="";
		Controller controller=controllerMap.get(command);
		
		/*
		 * 2-2.클라이언트요청에따른 업무실행 Controller객체의실행결과(이동할 패쓰) 반환받기
		 */
		forwardPath=controller.handleRequest(request, response);
		
		/*
		 * 3.jsp forward or redirect
		 * 		redirect:member_main.do
		 *      forward:/WEB-INF/views/member_main.jsp
		 */
		/************ forward or redirect****************/
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path=pathArray[1];
		
		if(forwardOrRedirect.equals("forward")) {
		 	//forward
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}else if(forwardOrRedirect.equals("redirect")){
			//redirect
			response.sendRedirect(path);
		}
		/*************************************************/
		
	}

}
