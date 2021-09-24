package com.itwill.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/user_main.do")
	public String user_main() {
		return "user_main";
	}
}