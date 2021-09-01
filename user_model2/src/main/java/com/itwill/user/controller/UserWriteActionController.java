package com.itwill.user.controller;

import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserWriteActionController implements Controller{

	private UserService userService;
	
	public UserWriteActionController() throws Exception {
		userService = new UserService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardPath ="";
		
		if(request.getMethod().equalsIgnoreCase("GET")){
			forwardPath="redirect:user_write_form.do";
			return forwardPath;
		} 
		
		//request.setCharacterEncoding("UTF-8");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		User newUser=new User(userId,password,name,email);
		//UserService userService=new UserService();
		try {	
			int result = this.userService.create(newUser);
			if(result==-1){ //아이디중복
				/** case 1 [redirect] **
				String msg=URLEncoder.encode(userId+" 는 이미존재하는 아이디입니다.", "UTF-8");
				forwardPath="redirect:user_write_form.do?msg="+msg;
				************************/
				
				/** case 2 [forward] **/
				String msg=userId+"는 이미 존재하는 아이디입니다.";
				request.setAttribute("msg", msg);
				request.setAttribute("fuser", newUser);
				forwardPath="forward:/WEB-INF/views/user_write_form.jsp"; //다이렉트로 넘기는 것
				// forwardPath="forward:user_write_form.do"; // do로 한번 갔다가 jsp로 포워딩되잖아. 불필요한 2번의 포워딩.
				//forwarding이 많으면 좋지 않음
				
			}else if(result==1){ //회원가입성공
				forwardPath="redirect:user_login_form.do";
			}
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="redirect:user_error.do";
		}
		
		//return "forward:/WEB-INF/views/user_write_action.jsp";
		return forwardPath;
	}
	
	
}
