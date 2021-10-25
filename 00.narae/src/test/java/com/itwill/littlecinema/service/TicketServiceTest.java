package com.itwill.littlecinema.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.service.interface_service.TicketService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class TicketServiceTest {

	@Autowired
	TicketService ticketService;

	@Test
	public void ticketServiceTest() throws Exception {
		System.out.println("----------- selectList -----------");
		List<Ticket> ticketList = ticketService.findTicketList("asurcombe1");
		for (Ticket ticket : ticketList) {
			System.out.println(ticket);
		}
		
	}

}
