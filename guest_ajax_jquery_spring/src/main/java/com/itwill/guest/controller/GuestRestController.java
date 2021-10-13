package com.itwill.guest.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value="guest/guest_list_json", produces="application/json;charset=utf-8")
	public List<Guest> quest_list_json() throws Exception {
		return guestService.selectAll();
	}
	
	
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
	
	@RequestMapping(value="guest/guest_detail_html", produces="text/html;charset=utf-8")
	public String guest_detail_html(@RequestParam int guest_no) throws Exception {
		
		Guest guest = guestService.selectByNo(guest_no);
		
		StringBuffer htmlSb=new StringBuffer();
		htmlSb.append("<div class=\"guest_date\">");
		htmlSb.append("날짜:"+guest.getGuest_date());
		htmlSb.append("</div>");
		htmlSb.append("<div class=\"guest_name\">");
		htmlSb.append("이름:"+guest.getGuest_name());
		htmlSb.append("</div>");
		htmlSb.append("<div class=\"guest_email\">");
		htmlSb.append("이메일:"+guest.getGuest_email());
		htmlSb.append("</div>");
		htmlSb.append("<div class=\"guest_homepage\">");
		htmlSb.append("홈페이지:"+guest.getGuest_homepage());
		htmlSb.append("</div>");
		htmlSb.append("<div class=\"guest_content\">");
		htmlSb.append("내용:"+guest.getGuest_content());
		htmlSb.append("</div>");
		htmlSb.append("<div class=\"guest_delete\">");
		htmlSb.append("<input type=\"button\" value=\"삭제\" guest_no=\""+guest.getGuest_no()+"\">");
		htmlSb.append("<input type=\"button\" value=\"수정\" guest_no=\""+guest.getGuest_no()+"\">");
		htmlSb.append("</div>");
		
		return htmlSb.toString();
	}
	
	@RequestMapping(value="guest/guest_insert_action", produces="text/plain;charset=utf-8")
	public String guest_insert_action(@ModelAttribute Guest guest) {
		String msg="false";
		try {
			guestService.insertGuest(guest);
			msg="true";
		} catch (Exception e) {
			e.printStackTrace();
			msg="false";
		}
		return msg;
	}
	
}
