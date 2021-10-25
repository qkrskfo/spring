package com.itwill.littlecinema.domain;

import java.util.Date;

public class Ticket {

	private int ticketNo;
	private Member member;
	private Time time;
	private int payCost;
	private Date orderDate;
	private int ticketStatus;

	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(Time time) {
		this.time = time;
	}
	
	public Ticket(Member member, Time time, int payCost) {
		this.member = member;
		this.time = time;
		this.payCost = payCost;
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

	public Member getMember() {
		return member;
	}

	public Time getTime() {
		return time;
	}

	public int getPayCost() {
		return payCost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public int isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public void setPayCost(int payCost) {
		this.payCost = payCost;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	@Override
	public String toString() {
		return "Ticket [ticketNo=" + ticketNo + ", member=" + member.getName() + ", time=" + time.getTimeCode() + ", payCost=" + payCost
				+ ", orderDate=" + orderDate + ", ticketStatus= " + ticketStatus + "]";
	}
	
	
}
