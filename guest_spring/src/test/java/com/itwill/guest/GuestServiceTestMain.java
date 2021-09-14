package com.itwill.guest;

import com.itwill.guest.GuestServiceImpl;

public class GuestServiceTestMain {

	public static void main(String[] args) throws Exception{
		GuestService guestService=new GuestServiceImpl();
		System.out.println(guestService.selectAll());

	}

}
