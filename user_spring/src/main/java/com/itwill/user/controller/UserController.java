package com.itwill.user.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.user.User;
import com.itwill.user.UserService;

@Controller
public class UserController {
	
	/*
	<<요청command>>
	/user_main
	/user_write_form
	/user_write_action
	/user_login_form
	/user_login_action
	/user_logout_action
	/user_list
	/user_view
	/user_view_myinfo
	/user_modify_form_myinfo
	/user_modify_action_myinfo
	/user_remove_action_myinfo
	/user_error
	 */
	@Autowired
	private UserService userService;
	
	/*
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	*/
	
	@RequestMapping(value="/user_main")
	public String user_main() {
		return "user_main";
	}
	
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		return "user_write_form";
	}
	
	
	@GetMapping(value="/user_write_action")
	public String user_write_action_get() {
		return "redirect:user_write_form";
	}
	
	@PostMapping(value="/user_write_action")
	public String user_write_action(@ModelAttribute User user, Model model) throws Exception {
		String forwardPath ="";
		int result = userService.create(user);
		if(result>0) {
			forwardPath = "redirect:user_login_form";
		} else {
			model.addAttribute("msg", user.getUserId()+"는 이미 존재하는 아이디입니다.");
			model.addAttribute("fuser", user);
			forwardPath ="user_write_form";
		}
		return forwardPath;
	}
	
		
	/*
	@RequestMapping(value="/user_write_action", method=RequestMethod.GET)
	public String user_write_action_get() {
		return "redirect:user_main.do";
	}
	
	@RequestMapping(value="/user_write_action", method=RequestMethod.POST)
	public String user_write_action(@ModelAttribute("user") User user, Model model) throws Exception {
		String forwardPath ="";
		int result = userService.create(user);
		if(result!=1) {
			model.addAttribute("msg", user.getUserId()+"는 이미 존재하는 아이디입니다.");
			model.addAttribute("fuser", user);
			forwardPath = "user_write_form";
		} else if(result==1) {
			forwardPath ="redirect:user_login_form.do";
		}
		return forwardPath;
	}
	*/
	
	
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		return "user_login_form";
	}
	
	@GetMapping(value="/user_login_action")
	public String user_login_action_get() {
		return "redirect:user_login_form";
	}
	
	@PostMapping(value="/user_login_action")
	public String user_login_action(@ModelAttribute User user, HttpSession session, Model model) throws Exception {
		String forwardPath = "";

		int result = userService.login(user.getUserId(), user.getPassword());
		if(result==0) {
			//아이디 존재 안함
			model.addAttribute("msg1", user.getUserId()+"는 존재하지 않는 아이디입니다.");
			model.addAttribute("fuser", user);
			forwardPath ="user_login_form";
		} else if(result==1) {
			//패스워드 불일치
			model.addAttribute("msg2", "패스워드가 일치하지 않습니다.");
			model.addAttribute("fuser", user);
			forwardPath ="user_login_form";
		} else if(result==2) {
			//패스워드 일치(로그인 성공)
			session.setAttribute("sUserId", user.getUserId());
			forwardPath = "redirect:user_main";
		}

		return forwardPath;
	}
	
	
	/*	
	@RequestMapping(value="/user_login_action.do", method=RequestMethod.GET)
	public String user_login_action_get() {
		return "redirect:user_login_form.do";
	}
	
	@RequestMapping(value="/user_login_action.do", method=RequestMethod.POST)
	public String user_login_action(@RequestParam(value="userId", required=false) String userId, @RequestParam(value="password") String password, Model model, HttpSession session) throws Exception {
		/* 
		required 속성의 default는 true이기 때문에 guest_no가 없을 시 false로 설정해줘야한다.
		required가 true일 경우에는 반드시 요구되기 때문에 400 에러가 나온다
		false일 경우엔 반드시 요구되지 않는다 라고 해서 null값이 들어가기때문에
		if(guest_no == null) 이 충족된다.
		defaultValue는 값이 들어오지않으면 defaultValue값으로 설정해라는 뜻
		여기선 ""공백이니까 if(guest_no.equals(""))이 충족된다.
		예를들어 defaultValue = "89" 이런식으로 주면 ?guest_no=89가 디폴트값으로 들어간다.
		*
		String forwardPath = "";
		int result = userService.login(userId, password);
		if(result==0) {
			User fuser=new User(userId,password,"",""); 
			model.addAttribute("msg1", "존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다.");
			model.addAttribute("fuser", fuser);
			forwardPath = "user_login_form";
		} else if(result==1) {
			User fuser=new User(userId,password,"",""); 
			model.addAttribute("msg2", "존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다.");
			model.addAttribute("fuser", fuser);
			forwardPath = "user_login_form";
		} else if(result==2) {
			session.setAttribute("sUserId", userId);
			forwardPath = "redirect:user_main.do";
		}
		return forwardPath;
	}
	*/
	
		
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpSession session) {
		session.invalidate();
		return "redirect:user_main";
	}
	
	@RequestMapping("/user_list")
	public String user_list(Model model) throws Exception {
		String forwardPath ="";

		List<User> userList = userService.findUserList();
		model.addAttribute("userList", userList);
		forwardPath = "user_list";

		return forwardPath;
	}
	
	/*
	@RequestMapping("/user_list")
	public String user_list(Model model) throws Exception {
		List<User> userList = userService.findUserList();
		model.addAttribute("userList", userList);
		return "user_list";
	}
	*/
	
	public String user_view() throws Exception {
		String forwardpath ="";
		
		return forwardpath;
	}
	/*
	@RequestMapping("/user_view.do")
	public String user_view(@RequestParam(value="userId", required=false, defaultValue="") String userId, Model model) throws Exception {
		if(userId==null || userId.equals("")) {
			return "redirect:user_main.do";
		}
		User user = userService.findUser(userId);
		model.addAttribute("user", user);
		return "user_view";
	}
	*/
	
	/*
	@RequestMapping("/user_view_myinfo.do")
	public String user_view_myinfo(Model model, HttpSession session) throws Exception {
		String sUserId = (String)session.getAttribute("sUserId");
		if(sUserId==null||sUserId.equals("")) {
			return "redirect:user_main.do";
		}
		User loginUser = userService.findUser(sUserId);
		model.addAttribute("loginUser", loginUser);
		return "user_view_myinfo";
	}
	
	@RequestMapping(value="/user_modify_form_myinfo.do")
	public String user_modify_form_myinfo(HttpSession session, Model model) throws Exception {
		String sUserId = (String)session.getAttribute("sUserId");
		if(sUserId==null||sUserId.equals("")) {
			return "redirect:user_main.do";
		}
		User loginUser = userService.findUser(sUserId);
		model.addAttribute("loginUser", loginUser);
		return "user_modify_form_myinfo";
	}
	
	@RequestMapping(value="/user_modify_action_myinfo.do", method=RequestMethod.GET)
	public String user_modify_action_myinfo_get() {
		return "redirect:user_main.do";
	}
	
	@RequestMapping(value="/user_modify_action_myinfo.do", method=RequestMethod.POST)
	public String user_modify_action_myinfo(@ModelAttribute("loginUser") User user, HttpSession session) throws Exception {
		String sUserId = (String)session.getAttribute("sUserId");
		if(sUserId==null||sUserId.equals("")) {
			return "redirect:user_main.do";
		}
		userService.update(new User(sUserId, user.getPassword(), user.getName(), user.getEmail()));
		return "user_view_myinfo";
	}
	
	@RequestMapping(value="/user_remove_action_myinfo.do", method=RequestMethod.GET)
	public String user_remove_action_myinfo_get() {
		return "redirect:user_main.do";
	}
	
	@RequestMapping(value="/user_remove_action_myinfo.do", method = RequestMethod.POST)
	public String user_remove_action_myinfo(HttpSession session) throws Exception {
		userService.remove((String)session.getAttribute("sUserId"));
		session.invalidate();
		return "redirect:user_main.do";
	}
	
	@RequestMapping("/user_error.do")
	public String user_error() {
		return "user_error";
	}
	*/
	
}