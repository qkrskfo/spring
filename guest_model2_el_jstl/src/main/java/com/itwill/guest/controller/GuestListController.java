package com.itwill.guest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestListController implements Controller{
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) {
		String forwardPath="";
		try{
			GuestService guestService=new GuestService();
			ArrayList<Guest> guestList=guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/view/guest_list.jsp";
		}catch(Exception e){
			e.printStackTrace();
			forwardPath="redirect:guest_error.do";
		}
		return forwardPath;
	}
}