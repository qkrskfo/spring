package com.itwill.littlecinema.domain;

import java.util.Date;
import java.util.List;

public class Ticket {

	private int ticketNo;
	private Member member;
	private Time time;
	private int payCost;
	private Date orderDate;
	private int ticketStatus;
	private List<BookedSeat> bookedSeatList;

	public Ticket() {
	}
	
	public Ticket(Time time) {
		this.time = time;
	}
	
	public Ticket(Member member, Time time, int payCost) {
		this.member = member;
		this.time = time;
		this.payCost = payCost;
		this.orderDate = new Date();
		this.ticketStatus = 1;
	}

	public Ticket(int ticketNo, Member member, Time time, int payCost, Date orderDate, int ticketStatus) {
		this.ticketNo = ticketNo;
		this.member = member;
		this.time = time;
		this.payCost = payCost;
		this.orderDate = orderDate;
		this.ticketStatus = ticketStatus;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getPayCost() {
		return payCost;
	}

	public void setPayCost(int payCost) {
		this.payCost = payCost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public List<BookedSeat> getBookedSeatList() {
		return bookedSeatList;
	}

	public void setBookedSeatList(List<BookedSeat> bookedSeatList) {
		this.bookedSeatList = bookedSeatList;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", member=" + member + ", time=" + time + ", payCost=" + payCost
				+ ", orderDate=" + orderDate + ", ticketStatus=" + ticketStatus + ", \n bookedSeatList=" + bookedSeatList
				+ "] \n";
	}
	
}
