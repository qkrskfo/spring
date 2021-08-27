package com.itwill.guest.controller;

import java.util.ArrayList;

public class GuestViewController {
	public String handleRequest() {
		String forwardPath="forward:/WEB-INF/view/guest_view.jsp";
		return forwardPath;
	}
}