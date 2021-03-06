package com.itwill.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.user.Account;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;



/*
<<요청command>>
/user_id_duplicate_check

 */
@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user_id_duplicate_check_rest",produces = "text/plain;charset=UTF-8")
	public String user_id_duplicate_check(@RequestParam String userId) throws Exception{
		boolean isDuplicate= userService.isDuplcateUserId(userId);
		System.out.println(!isDuplicate+"-->"+userId);
		return !isDuplicate+"";
	}
	@LoginCheck
	@RequestMapping(value = "user_name_rest",produces = "text/plain;charset=UTF-8")
	public String user_name_rest(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		User sUser=userService.findUser(sUserId);
		return sUser.getName();
	}
	@LoginCheck
	@PostMapping(value = "/user_profile_modify_action_rest",produces = "application/json;charset=UTF-8")
	public User user_profile_modify_action_rest( @ModelAttribute Account account,HttpSession session) throws Exception {
		String loginUserId=(String)session.getAttribute("sUserId");
		User loginUser=userService.findUser(loginUserId);
		
		if(loginUser.getPassword().equals(account.getAccount_pass())) {
			loginUser.setUserId(loginUserId);
			loginUser.setName(account.getAccount_ln()+account.getAccount_fn());
			loginUser.setEmail(account.getAccount_email());
			userService.update(loginUser);
			return loginUser;
		}else {
			return new User();
		}
		
		
	}
}
