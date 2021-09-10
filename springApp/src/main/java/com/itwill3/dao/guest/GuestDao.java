package com.itwill3.dao.guest;

import java.util.ArrayList;

public interface GuestDao {

	int insertGuest(Guest guest) throws Exception;

	/*
	/*
	이름             널?       유형             
	-------------- -------- -------------- 
	GUEST_NO       NOT NULL NUMBER(10)     
	GUEST_NAME     NOT NULL VARCHAR2(10)   
	GUEST_DATE     NOT NULL DATE           
	GUEST_EMAIL             VARCHAR2(50)   
	GUEST_HOMEPAGE          VARCHAR2(50)   
	GUEST_TITLE    NOT NULL VARCHAR2(100)  
	GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
	 */
	Guest selectByNo(int no) throws Exception;

	ArrayList<Guest> selectAll() throws Exception;

	int updateGuest(Guest guest) throws Exception;

	int deleteGuest(int no) throws Exception;

}