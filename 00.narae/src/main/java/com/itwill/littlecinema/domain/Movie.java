package com.itwill.littlecinema.domain;

import java.util.Date;
import java.util.List;

public class Movie {
	
	private int movieNo;
	private String title;
	private Date openDate;
	private String director;
	private String actors;
	private String genre;
	private String runningtime;
	private String summary;
	private String rating;
	private String posterImage;
	private List<Time> timeList;
	private List<Review> reviewList;
	
	public Movie() {
	}
	
	public Movie(int movieNo, String title, Date openDate, String director, String actors, String genre,
			String runningtime, String summary, String rating, String posterImage) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.openDate = openDate;
		this.director = director;
		this.actors = actors;
		this.genre = genre;
		this.runningtime = runningtime;
		this.summary = summary;
		this.rating = rating;
		this.posterImage = posterImage;
	}
	
	public Movie(int movieNo, String title, Date openDate, String director, String actors, String genre,
			String runningtime, String summary, String rating, String posterImage, List<Time> timeList,
			List<Review> reviewList) {
		super();
		this.movieNo = movieNo;
		this.title = title;
		this.openDate = openDate;
		this.director = director;
		this.actors = actors;
		this.genre = genre;
		this.runningtime = runningtime;
		this.summary = summary;
		this.rating = rating;
		this.posterImage = posterImage;
		this.timeList = timeList;
		this.reviewList = reviewList;
	}

	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRunningtime() {
		return runningtime;
	}
	public void setRunningtime(String runningtime) {
		this.runningtime = runningtime;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPosterImage() {
		return posterImage;
	}
	public void setPosterImage(String posterImage) {
		this.posterImage = posterImage;
	}
	public List<Time> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Time> timeList) {
		this.timeList = timeList;
	}
	public List<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	@Override
	public String toString() {
		return "Movie [movieNo=" + movieNo + ", title=" + title + ", openDate=" + openDate + ", director=" + director
				+ ", actors=" + actors + ", genre=" + genre + ", runningtime=" + runningtime + ", summary=" + summary
				+ ", rating=" + rating + ", posterImage=" + posterImage + ", \n timeList=" + timeList + ", \n reviewList="
				+ reviewList + "] \n";
	}

}
