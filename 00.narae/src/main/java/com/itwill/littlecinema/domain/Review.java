package com.itwill.littlecinema.domain;

public class Review {
	private int reviewNo;
	private Member member;
	private Movie movie;
	private int score;
	private String reviewComment;
	
	public Review() {
	}

	public Review(int reviewNo, int score, String reviewComment) { //리뷰 수정할 때 씀
		this.reviewNo = reviewNo;
		this.score = score;
		this.reviewComment = reviewComment;
	}

	public Review(Member member, Movie movie, int score, String reviewComment) {
		this.member = member;
		this.movie = movie;
		this.score = score;
		this.reviewComment = reviewComment;
	}

	public Review(int reviewNo, Member member, Movie movie, int score, String reviewComment) {
		this.reviewNo = reviewNo;
		this.member = member;
		this.movie = movie;
		this.score = score;
		this.reviewComment = reviewComment;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", member=" + member + ", movie=" + movie + ", score=" + score
				+ ", reviewComment=" + reviewComment + "] \n";
	}
	

	
}
