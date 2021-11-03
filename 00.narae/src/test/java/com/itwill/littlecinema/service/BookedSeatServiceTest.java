package com.itwill.littlecinema.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;
import com.itwill.littlecinema.repository.interface_dao.MemberDao;
import com.itwill.littlecinema.repository.interface_dao.TicketDao;
import com.itwill.littlecinema.repository.interface_dao.TimeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class BookedSeatServiceTest {

	@Autowired
	private BookedSeatDao bsd;
	
	@Autowired
	private TicketDao td;

	@Autowired
	private MemberDao md;
	
	@Autowired
	private TimeDao td2;
	
	@Test
	public void bookedSeatDaoTest() throws Exception {	
	}

	
}
