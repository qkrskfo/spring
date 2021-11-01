package com.itwill.shop.order;

public class Card {
	private String number;
	private String name;
	private String expiry;
	private String cvc;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	@Override
	public String toString() {
		return "Card [number=" + number + ", name=" + name + ", expiry=" + expiry + ", cvc=" + cvc + "]";
	}
	
}
