package com.itwill.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.user.UserService;



/*
<<요청command>>
/user_id_duplicate_check

 */
@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	@RequestMapping(value = "/user_id_duplicate_check_rest")
	public String user_id_duplicate_check(@RequestParam String userId) throws Exception{
		boolean isDuplicate= userService.isDuplcateUserId(userId);
		System.out.println(isDuplicate+"-->"+userId);
		return !isDuplicate+"";
	}
	
}
