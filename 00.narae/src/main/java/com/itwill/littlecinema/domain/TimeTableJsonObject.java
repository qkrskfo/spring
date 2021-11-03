package com.itwill.littlecinema.domain;

public class TimeTableJsonObject {
	
	private int timeCode;
	private Screen screen;
	private String startTime;
	private String endTime;
	private int bookedCount;
	
	public TimeTableJsonObject(int timeCode, Screen screen, String startTime, String endTime, int bookedCount) {
		this.timeCode = timeCode;
		this.screen = screen;
		this.startTime = startTime;
		this.endTime = endTime;
		this.bookedCount = bookedCount;
	}

	public int getTimeCode() {
		return timeCode;
	}

	public Screen getScreen() {
		return screen;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public int getBookedCount() {
		return bookedCount;
	}

	public void setTimeCode(int timeCode) {
		this.timeCode = timeCode;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setBookedCount(int bookedCount) {
		this.bookedCount = bookedCount;
	}
	
	
}
