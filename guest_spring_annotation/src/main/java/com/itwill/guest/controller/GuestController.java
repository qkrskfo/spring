package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	
	/*
	<< 요청url (command) >>
	/guest_main.do=com.itwill.guest.controller.GuestMainController
	/guest_write_form.do=com.itwill.guest.controller.GuestWriteFormController
	/guest_write_action.do=com.itwill.guest.controller.GuestWriteActionController
	/guest_list.do=com.itwill.guest.controller.GuestListController
	/guest_view.do=com.itwill.guest.controller.GuestViewController
	/guest_modify_form.do=com.itwill.guest.controller.GuestModifyFormController
	/guest_modify_action.do=com.itwill.guest.controller.GuestModifyActionController
	/guest_remove_action.do=com.itwill.guest.controller.GuestRemoveActionController
	/guest_error.do=com.itwill.guest.controller.GuestErrorController
	*/

	private GuestService guestService;
	
	@Autowired
	//@Qualifier("guestService") guestService라는 id로 인젝션/지우면 type에 맞는 객체 인젝션
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}

	/*
	 * <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 * 		<property name="prefix" value="/WEB-INF/views/"/> 
	 *  	<property name="suffix" value=".jsp"/> 
	 * </bean>
	 * 
	 * << Controller반환 String >> 
	 * 		1.forward:/WEB-INF/views/response_view_name.jsp ==>prefix,suffix설정적용안됨 
	 * 		2.response_view_name ==> prefix,suffix설정적용됨
	 * 		3.redirect:xxx.jsp ==> prefix,suffix설정적용안됨
	 */

	
	@RequestMapping("/guest_main.do")
	public String guest_main() {
		return "guest_main";
	}
	
	@RequestMapping("/guest_list.do")
	public String guest_list(Model model) throws Exception {
		String forwardPath = "";
		ArrayList<Guest> guestList = guestService.selectAll();
		model.addAttribute("guestList", guestList);
		forwardPath = "guest_list";
		return forwardPath;
	}
	
	@RequestMapping("/guest_view.do")
	public String guest_view(@RequestParam(value="guest_no", required=false, defaultValue="") String guest_no, Model model) throws Exception {
		//required 속성의 default는 true이기 때문에 guest_no가 없을 시 false로 설정해줘야한다.
		//required가 true일 경우에는 반드시 요구되기 때문에 400 에러가 나온다
		//false일 경우엔 반드시 요구되지 않는다 라고 해서 null값이 들어가기때문에
		//if(guest_no == null) 이 충족된다.
		//defaultValue는 값이 들어오지않으면 defaultValue값으로 설정해라는 뜻
		//여기선 ""공백이니까 if(guest_no.equals(""))이 충족된다.
		//예를들어 defaultValue = "89" 이런식으로 주면 ?guest_no=89가 디폴트값으로 들어간다.
		String forwardPath="";
		if(guest_no==null || guest_no.equals("")) {
			forwardPath="redirect:guest_list.do";
			return forwardPath;
		}
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
			model.addAttribute("guest", guest);
			forwardPath="guest_view";
		return forwardPath;
	}
	
	@RequestMapping("/guest_write_form.do")
	public String guest_write_form() {
		return "guest_write_form";
	}
	
	@RequestMapping(value="/guest_write_action.do", method=RequestMethod.GET)
	public String guest_write_action_get() {
		return "redirect:guest_main.do";
	}
	
	
	@RequestMapping(value="/guest_write_action.do", method=RequestMethod.POST)
	public String guest_write_action(@ModelAttribute("guest") Guest guest) throws Exception {
		String forwardPath = "";
		int pk = guestService.insertGuest(guest);
		forwardPath="redirect:guest_view.do?guest_no="+pk;
		return forwardPath;
	}
	
	@RequestMapping(value="/guest_modify_form.do", method=RequestMethod.GET)
	public String guest_modify_form_get() {
		return "redirect:guest_main.do";
	}
	
	
	@RequestMapping(value="/guest_modify_form.do", method = RequestMethod.POST)
	public String guest_modify_form(@RequestParam(value="guest_no", required=false, defaultValue="") String guest_no, Model model) throws Exception {
		String forwardPath ="";
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
			model.addAttribute("guest", guest);
			forwardPath="guest_modify_form";
		return forwardPath;
	}
	
	@RequestMapping(value="/guest_modify_action.do", method=RequestMethod.GET)
	public String guest_modify_action_get() {
		return "redirect:guest_main.do";
	}
	
	@RequestMapping(value="/guest_modify_action.do", method = RequestMethod.POST)
	public String guest_modify_action(@ModelAttribute("guest") Guest guest) throws Exception {
		String forwardPath ="";
			guestService.updateGuest(guest);
			forwardPath="redirect:guest_view.do?guest_no="+guest.getGuest_no();
		return forwardPath;
	}
	@RequestMapping(value="/guest_remove_action.do", method=RequestMethod.GET)
	public String guest_remove_action_get() {
		return "redirect:guest_main.do";
	}
	
	@RequestMapping(value="/guest_remove_action.do", method = RequestMethod.POST)
	public String guest_remove_action(@RequestParam(value="guest_no", required=false, defaultValue="") String guest_no) throws Exception {
		String forwardPath ="";
		guestService.deleteGuest(Integer.parseInt(guest_no));
		forwardPath = "redirect:guest_list.do";
		return forwardPath;
	}
	
	@RequestMapping("/guest_error.do")
	public String guest_error() {
		return "guest_error";
	}
	
	
	/*
	@RequestMapping("/guest_list.do")
	public String guest_list(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = "";
		try {
			ArrayList<Guest> guestList = guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
	

	
	@RequestMapping("/guest_view.do")
	public String guest_view(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath ="";
		String guest_noStr = request.getParameter("guest_no");
		if(guest_noStr==null||guest_noStr.equals("")) {
			return "redirect:guest_list.jsp";
		}
		try {
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
			if(guest==null) {
				return "redirect:guest_list.do";
			}
			request.setAttribute("guest", guest);
			forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="foward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
	
	@RequestMapping("/guest_write_form.do")
	public String guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping(value="/guest_write_action.do", method = RequestMethod.POST)
	public String guest_write_action(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath ="";
		try {
			String guest_name = request.getParameter("guest_name");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
			Guest guest = new Guest(0, guest_name, null, guest_email, guest_homepage, guest_title, guest_content);
			guestService.insertGuest(guest);
			forwardPath="redirect:guest_list.do";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="foward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}  
	
	@RequestMapping(value="/guest_modify_form.do", method = RequestMethod.POST)
	public String guest_modify_form(HttpServletRequest request, HttpServletRequest response) {
		String forwardPath ="";
		try {
			String guest_noStr = request.getParameter("guest_no");
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
			request.setAttribute("guest", guest);
			forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="foward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
	
	@RequestMapping(value="/guest_modify_action.do", method = RequestMethod.POST)
	public String guest_modify_action(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath ="";
		try {
			String guest_noStr=request.getParameter("guest_no");
			String guest_name = request.getParameter("guest_name");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
			Guest updateGuest = new Guest(
					Integer.parseInt(guest_noStr),guest_name,
					null,guest_email,guest_homepage,
					guest_title,guest_content);
			guestService.updateGuest(updateGuest);
			forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="foward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}
	
	@RequestMapping(value="/guest_remove_action.do", method = RequestMethod.POST)
	public String guest_remove_action(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath ="";
		try {
			String guest_noStr = request.getParameter("guest_no");
			guestService.deleteGuest(Integer.parseInt(guest_noStr));
			forwardPath = "redirect:guest_list.do";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="foward:/WEB-INF/views/guest_error.jsp";
		}
		
		return forwardPath;
	}
	
	@RequestMapping("/guest_error.do")
	public String guest_error() {
		return "forward:/WEB-INF/views/guest_error.jsp";
	}
	*/
	
	
	
}
