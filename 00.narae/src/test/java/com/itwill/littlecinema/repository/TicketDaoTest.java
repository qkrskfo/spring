package com.itwill.littlecinema.repository;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.repository.interface_dao.MemberDao;
import com.itwill.littlecinema.repository.interface_dao.TicketDao;
import com.itwill.littlecinema.repository.interface_dao.TimeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TicketDaoTest {

	@Autowired
	private TicketDao td;

	@Autowired
	private MemberDao md;
	
	@Autowired
	private TimeDao td2;

	@Test
	public void ticketDaoTest() throws Exception {
		System.out.println("----------- selectList -----------");
		/*
		List<Ticket> ticketList = td.selectTicketList("asurcombe1");
		for (Ticket ticket : ticketList) {
			System.out.println(ticket);
		}
		*/
		/*
		System.out.println("----------- insert -----------");
		List<Time> timeList = td2.selectScreenTimeByDate("2021-10-21");
		Ticket ticket = new Ticket(0, md.select("asurcombe1"), timeList.get(0), 1, new Date(), 1);
		System.out.println(td.insert(ticket));
		
		System.out.println("----------- update -----------");
		System.out.println(td.update(ticket.getTicketNo()));
		
		System.out.println("----------- selectList -----------");
		ticketList = td.selectTicketList("asurcombe1");
		for (Ticket ticket2 : ticketList) {
			System.out.println(ticket2);
		}
		*/
		System.out.println("-------- selectTicketBookedSeatByNo --------");
		System.out.println(td.selectTicketBookedSeatByNo(3));
		
		
	}
	
}
