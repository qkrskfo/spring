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
	 * controller 객체들을 저장하는 맵
	 */
	private HashMap<String, Controller> controllerMap;
	public DispatcherServlet() {
		System.out.println("0.DispatcherServlet()생성자");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		controllerMap = new HashMap<String,Controller>();
		
		System.out.println("0.DispatcherServlet.init()");
		String configFile="/WEB-INF/guest_controller_mapping.properties";
		ServletContext servletContext = this.getServletContext();
		String configFileRealPath = servletContext.getRealPath(configFile);
		try {
			FileInputStream in = new FileInputStream(configFileRealPath);
			Properties controllerMappingProperties = new Properties();
			controllerMappingProperties.load(in);
			System.out.println("----------"+configFile+"-------------");
			//System.out.println(controllerMappingProperties);
			Set commandKeySet = controllerMappingProperties.keySet();
			Iterator commandKeyIterator = commandKeySet.iterator();
			while(commandKeyIterator.hasNext()) {
				String command = (String)commandKeyIterator.next();
				String controllerClassName = controllerMappingProperties.getProperty(command);
				//System.out.println(command+"-->"+controllerClassName);
				Class controllerClass = Class.forName(controllerClassName);
				Controller controllerObject = (Controller)controllerClass.newInstance();
				controllerMap.put(command, controllerObject);
				System.out.println(command+"="+controllerObject);
			}
			System.out.println("-------------------------------------");
		} catch (Exception e) {
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
		 * 2.클라이언트 요청에 따른 업무실행 controller객체의 생성
		 */
		/*#################################################################*/
		/*
		<<요청 url(command)>>
		/guest_main.do  		
		/guest_list.do			
		/guest_view.do			
		/guest_write_form.do	
		/guest_write_action.do	
		/guest_modify_form.do	
		/guest_modify_action.do	
		/guest_remove_action.do	
		/guest_error.do		
		 * 
		 * 데이터를 넘겨야될땐 FORWARD
		 * 데이터를 안넘길땐 REDIRECT
		 * FORWARD를 쓸 때 발생하는 문제점들이 있어서 REDIRECT가 좋음
		 * 	
		 */
		
		String forwardPath="";
		Controller controller=controllerMap.get(command);
		
		/*
		if(command.equals("/guest_main.do")) {
			controller=new GuestMainController();
		}else if(command.equals("/guest_list.do")) {
			controller=new GuestListController();
		}else if(command.equals("/guest_view.do")) {
			controller=new GuestViewController();
		}else if(command.equals("/guest_write_form.do")) {
			controller=new GuestWriteFormController();
		}else if(command.equals("/guest_write_action.do")) {
			controller= new GuestWriteActionController();
		}else if(command.equals("/guest_modify_form.do")) {
			controller= new GuestModifyFormController();
		}else if(command.equals("/guest_modify_action.do")) {
			controller= new GuestModifyActionController();
		}else if(command.equals("/guest_remove_action.do")) {
			controller= new GuestRemoveActionController();
		}else if(command.equals("/guest_error.do")){
			//request.setAttribute("error_msg","잘못된요청입니다.");
			//forwardPath="forward:/WEB-INF/view/guest_error.jsp";
			controller= new GuestErrorController();
		}
		// 이렇게 되면 error.do로 오는 애들 말고 다른 애들은 에러페이지가 안뜨는뎅?...
		*/
		
		/*
		 * 2-2.클라이언트요청에따른 업무실행 Controller객체의실행결과(이동할 패쓰) 반환받기
		 */
		//위에서 자꾸 반복하지말고, 다 끝난다음에 여기서 호출하면 다 들어가잖아
		forwardPath=controller.handleRequest(request, response);
		
		/*#################################################################*/
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