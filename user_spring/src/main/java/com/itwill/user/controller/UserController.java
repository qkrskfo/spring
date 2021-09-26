package com.itwill.user.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	public String user_write_action(@ModelAttribute("user") User user) throws Exception {
		userService.create(user);
		return "user_login_form";
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
	public String user_login_action(@RequestParam(value="userId", required=false) String userId, @RequestParam(value="password") String password) throws Exception {
		userService.login(userId, password);
		return "user_main";
	}
	
	@RequestMapping("/user_logout_action.do")
	public String user_logout_action(HttpSession session) {
		String forwardPath ="";
		session.invalidate();
		forwardPath ="redirect:user_main.do";
		return forwardPath;
	}
	
	@RequestMapping("/user_list.do")
	public String user_list(Model model) throws Exception {
		String forwardPath ="";
		List<User> userList = userService.findUserList();
		model.addAttribute("userList", userList);
		forwardPath = "user_list";
		return forwardPath;
	}
	
	@RequestMapping("/user_view.do")
	public String user_view(@RequestParam(value="userId", required=false, defaultValue="") String userId, Model model) throws Exception {
		String forwardPath = "";
		if(userId==null || userId.equals("")) {
			forwardPath="redirect:user_main.do";
			return forwardPath;
		}
		User user = userService.findUser(userId);
		model.addAttribute("user", user);
		forwardPath = "user_view";
		return forwardPath;
	}
	
	@RequestMapping("/user_view_myinfo.do")
	public String user_view_myinfo(Model model, HttpSession session) throws Exception {
		String forwardPath = "";
		String sUserId = (String)session.getAttribute("sUserId");
		User user = userService.findUser(sUserId);
		model.addAttribute("user", user);
		forwardPath = "user_view_myinfo";
		return forwardPath;
	}
	
	@RequestMapping(value="/user_modify_form.do", method=RequestMethod.GET)
	public String user_modify_form_get() {
		return "redirect:user_main.do";
	}
	
	
	@RequestMapping(value="/user_modify_form.do", method = RequestMethod.POST)
	public String user_modify_form(@RequestParam(value="userId", required=false, defaultValue="") String userId, Model model) throws Exception {
		String forwardPath ="";
		
		return forwardPath;
	}
	
}