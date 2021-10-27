package com.itwill.littlecinema.domain;

public class Seat {
	private String seatCode;
	private Screen screen;
	
	public Seat() {
	}
	
	public Seat(String seatCode, Screen screen) {
		super();
		this.seatCode = seatCode;
		this.screen = screen;
	}

	public String getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	public Screen getScreen() {
		return screen;
	}
	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return "Seat [seatCode=" + seatCode + ", screen=" + screen + "] \n";
	}
	
}
