package com.itwill.user.annotation;


public class UserAnnotation {
	
	private String userId;
	private String password;
	private String name;
	private String email;

	public UserAnnotation() {
		System.out.println("#### UserAnnotation : 디폴트생성자호출");
		
	}

	public UserAnnotation(String userId, String password, String name, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		System.out.println("#### UserAnnotation : User(String userId, String password, String name, String email) : 생성자호출");
		
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		System.out.println("#### UserAnnotation : setUserId("+userId+") 호출");
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("#### UserAnnotation : setPassword(String password) 호출");
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("#### UserAnnotation : setName(String name) 호출");
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("#### UserAnnotation :setEmail(String email) 호출");
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserAnnotation:"+userId+","+password+","+name+","+email;
	}
	/*
	 *패쓰워드 일치여부 검사 
	 */
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.password.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}
	

}