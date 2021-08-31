package com.itwill.bean;

public class Student {

	private int no; //property type --> int
	private String name; //property type --> String
	private Car car; //property type --> Car
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int no, String name, Car car) {
		super();
		this.no = no;
		this.name = name;
		this.car = car;
	}

	//getter
	public Car getCar() {
		return this.car;
	}
	
	//setter
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
