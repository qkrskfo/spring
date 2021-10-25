package com.itwill.littlecinema.domain;

public class BookedSeat {
	
	private Ticket ticket;
	private Seat seat;

	public BookedSeat() {
		// TODO Auto-generated constructor stub
	}
	
	public BookedSeat(Ticket ticket, Seat seat) {
		this.ticket = ticket;
		this.seat = seat;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "BookedSeat [ticketNo=" + ticket.getTicketNo() +
				", seatCode=" + seat.getSeatCode() +
				", screenName=" + seat.getScreen().getScreenName() + "]";
	}
	
}
