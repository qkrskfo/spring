package com.itwill.littlecinema.domain;

import java.util.Date;

public class Member {

	private String id;
	private String password;
	private String name;
	private String phone;
	private Date birth_date;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String password, String name, String phone, Date birth_date) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.birth_date = birth_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", birth_date="
				+ birth_date + "] \n";
	}
	
}
