package com.itwill.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.user.User;
import com.itwill.user.UserService;

@Controller
public class UserController {
	/*
	<<요청command>>
	/user_main.do
	/user_write_form.do
	/user_write_action.do
	/user_login_form.do
	/user_login_action.do
	/user_logout_action.do
	/user_list.do
	/user_view.do
	/user_view_myinfo.do
	/user_modify_form_myinfo.do
	/user_modify_action_myinfo.do
	/user_remove_action_myinfo.do
	/user_error.do
	 */
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/user_main.do")
	public String user_main() {
		return "user_main";
	}
	
	@RequestMapping("/user_write_form.do")
	public String user_write_form() {
		return "user_write_form";
	}
	
	@RequestMapping(value="/user_write_action.do", method=RequestMethod.GET)
	public String user_write_action_get() {
		return "redirect:user_main.do";
	}
	
	@RequestMapping(value="/user_write_action.do", method=RequestMethod.POST)
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
	
	@RequestMapping("/user_login_form.do")
	public String user_login_form() {
		return "user_login_form";
	}
	
	@RequestMapping(value="/user_login_action.do", method=RequestMethod.GET)
	public String user_login_action_get() {
		return "redirect:user_login_form.do";
	}
	
	@RequestMapping(value="/user_login_action.do", method=RequestMethod.POST)
	public String user_login_action(@RequestParam(value="userId", required=false) String userId, @RequestParam(value="password") String password, Model model, HttpSession session) throws Exception {
		String forwardPath = "";
		int result = userService.login(userId, password);
		if(result==0 || result ==1) {
			model.addAttribute("msg", "존재하지 않는 아이디거나 비밀번호가 일치하지 않습니다.");
			User fuser=new User(userId,password,"",""); 
			model.addAttribute("fuser", fuser);
			forwardPath = "user_login_form";
		} else if(result==2) {
			session.setAttribute("sUserId", userId);
			forwardPath = "redirect:user_main.do";
		}
		return forwardPath;
	}
	
	@RequestMapping("/user_logout_action.do")
	public String user_logout_action(HttpSession session) {
		session.invalidate();
		return "redirect:user_main.do";
	}
	
	@RequestMapping("/user_list.do")
	public String user_list(Model model) throws Exception {
		List<User> userList = userService.findUserList();
		model.addAttribute("userList", userList);
		return "user_list";
	}
	
	@RequestMapping("/user_view.do")
	public String user_view(@RequestParam(value="userId", required=false, defaultValue="") String userId, Model model) throws Exception {
		if(userId==null || userId.equals("")) {
			return "redirect:user_main.do";
		}
		User user = userService.findUser(userId);
		model.addAttribute("user", user);
		return "user_view";
	}
	
	@RequestMapping("/user_view_myinfo.do")
	public String user_view_myinfo(Model model, HttpSession session) throws Exception {
		String sUserId = (String)session.getAttribute("sUserId");
		User user = userService.findUser(sUserId);
		model.addAttribute("user", user);
		return "user_view_myinfo";
	}
	
	@RequestMapping(value="/user_modify_form.do", method=RequestMethod.GET)
	public String user_modify_form_get() {
		return "redirect:user_main.do";
	}
	
	
	@RequestMapping(value="/user_modify_form_myinfo.do", method = RequestMethod.POST)
	public String user_modify_form_myinfo(HttpSession session, Model model) throws Exception {
		User user = userService.findUser((String)session.getAttribute("sUserId"));
		model.addAttribute("user", user);
		return "user_modify_form_myinfo";
	}
	
	@RequestMapping(value="/user_modify_action_myinfo.do", method=RequestMethod.GET)
	public String user_modify_action_myinfo_get() {
		return "redirect:user_main.do";
	}
	
	@RequestMapping(value="/user_modify_action_myinfo.do", method=RequestMethod.POST)
	public String user_modify_action_myinfo(@ModelAttribute("user") User user, HttpSession session) throws Exception {
		String sUserId = (String)session.getAttribute("sUserId");
		userService.update(new User(sUserId, user.getPassword(), user.getName(), user.getEmail()));
		return "user_view_myinfo";
	}
	
	@RequestMapping(value="/user_remove_action.do", method=RequestMethod.GET)
	public String user_remove_action_get() {
		return "redirect:user_main.do";
	}
	
	@RequestMapping(value="/user_remove_action.do", method = RequestMethod.POST)
	public String user_remove_action(HttpSession session) throws Exception {
		userService.remove((String)session.getAttribute("sUserId"));
		session.invalidate();
		return "redirect:user_main.do";
	}
	
	@RequestMapping("/user_error.do")
	public String user_error() {
		return "user_error";
	}
	
	
}