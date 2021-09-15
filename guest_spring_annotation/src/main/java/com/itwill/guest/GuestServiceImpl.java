package com.itwill.guest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("guestService")
@Service("guestService")
public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;

	public GuestServiceImpl() {
	
	}
	@Autowired
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}


	@Override
	public int insertGuest(Guest guest) throws Exception {
		return guestDao.insertGuest(guest);
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return guestDao.selectByNo(no);
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		return guestDao.selectAll();
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		return guestDao.updateGuest(guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return guestDao.deleteGuest(no);
	}

}
