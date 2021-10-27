package com.itwill.littlecinema.domain;

import java.util.Date;

public class Time {
	private int timeCode;
	private Screen screen;
	private Movie movie;
	private String startTime;
	private String endTime;
	private Date movieDate;
	
	public Time() {
	}

	public Time(int timeCode) {
		super();
		this.timeCode = timeCode;
	}

	public Time(int timeCode, Screen screen, Movie movie, String startTime, String endTime, Date movieDate) {
		super();
		this.timeCode = timeCode;
		this.screen = screen;
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = endTime;
		this.movieDate = movieDate;
	}

	public int getTimeCode() {
		return timeCode;
	}

	public void setTimeCode(int timeCode) {
		this.timeCode = timeCode;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	@Override
	public String toString() {
		return "Time [timeCode=" + timeCode + ", screen=" + screen + ", movie=" + movie + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", movieDate=" + movieDate + "] \n" ;
	}
	
}
