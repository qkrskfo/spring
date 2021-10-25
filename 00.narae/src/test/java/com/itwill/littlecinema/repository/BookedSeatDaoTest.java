package com.itwill.littlecinema.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwill.littlecinema.domain.BookedSeat;
import com.itwill.littlecinema.domain.Screen;
import com.itwill.littlecinema.domain.Seat;
import com.itwill.littlecinema.domain.Ticket;
import com.itwill.littlecinema.domain.Time;
import com.itwill.littlecinema.repository.interface_dao.BookedSeatDao;
import com.itwill.littlecinema.repository.interface_dao.MemberDao;
import com.itwill.littlecinema.repository.interface_dao.TicketDao;
import com.itwill.littlecinema.repository.interface_dao.TimeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-config.xml")
public class BookedSeatDaoTest {
	
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
		
		System.out.println("----------------- select -----------------");
		//2021-10-21에 있는 영화들 중에 가장 첫번째 거 가져오기 EX TIME_CODE)10
		Time time = td2.selectScreenTimeByDate("2021-10-21").get(0);
		
		//위에 time.timeCode로 예약된 좌석 불러오기
		List<BookedSeat> bookedSeatList = bsd.selectBookedSeatList(time.getTimeCode());
		
		for (BookedSeat bookedSeat : bookedSeatList) {
			System.out.println("#### : " + bookedSeat);
		}
		
		/*System.out.println("----------------- insert -----------------");
		List<Ticket> tl = td.selectTicketList(md.select("asurcombe1")); //asurcombe1유저의 예약목록
		Ticket t = tl.get(tl.size() - 1); //마지막으로 예약된 예매정보 ex)
		
		System.out.println(bsd.insert(new BookedSeat(t, new Seat("A01", new Screen(1, "test")))));
		
		System.out.println("----------------- select -----------------");
		bookedSeatList = bsd.selectBookedSeatList(new Ticket(time));
		for (BookedSeat bookedSeat : bookedSeatList) {
			System.out.println(bookedSeat);
		}*/
		
	}
	
}
