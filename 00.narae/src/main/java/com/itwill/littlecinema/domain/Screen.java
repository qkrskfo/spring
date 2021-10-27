package com.itwill.littlecinema.domain;

public class Screen {
	private int screenNo;
	private String screenName;
	
	public Screen() {
	}
	
	public Screen(int screenNo, String screenName) {
		super();
		this.screenNo = screenNo;
		this.screenName = screenName;
	}

	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	@Override
	public String toString() {
		return "Screen [screenNo=" + screenNo + ", screenName=" + screenName + "] \n";
	}
	
}
