package com.itwill.guest;

import java.util.ArrayList;

public interface GuestService {

	int insertGuest(Guest guest) throws Exception;

	Guest selectByNo(int no) throws Exception;

	ArrayList<Guest> selectAll() throws Exception;

	int updateGuest(Guest guest) throws Exception;

	int deleteGuest(int no) throws Exception;

}