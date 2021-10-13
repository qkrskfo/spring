package com.itwill.guest.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="guest/guest_list_html", produces="text/html;charset=utf-8")
	public String quest_list_html() throws Exception {
		/*
		 <div class="guest_item">
		 	<h3 class="guest_title" guest_no="1"><a href="">방명록 사용법[HTML]</a></h3>
		 </div>
		 */
		List<Guest> guestList = guestService.selectAll();
		StringBuffer htmlSb = new StringBuffer();
		for (Guest guest : guestList) {
			htmlSb.append("<div class=\"guest_item\">");
			htmlSb.append("<h3 class=\"guest_title\" guest_no=\""+guest.getGuest_no()+"\"><a href=\"\">"+guest.getGuest_title()+"[HTML]</a></h3>");
			htmlSb.append("</div>");
		}
		return htmlSb.toString();
	}
	
	@RequestMapping(value="guest/guest_detail_html")
	public String guest_detail_html() throws Exception {
		
	}
	
}
