package com.itwill.shop.order;

public class Address {
	private String checkout_fn;
	private String checkout_ln;
	private String checkout_email;
	private String checkout_phone;
	private String checkout_company;
	private String checkout_country;
	private String checkout_city;
	private String checkout_zip;
	private String checkout_address1;
	private String checkout_address2;
	public String getCheckout_fn() {
		return checkout_fn;
	}
	public void setCheckout_fn(String checkout_fn) {
		this.checkout_fn = checkout_fn;
	}
	
	public String getCheckout_ln() {
		return checkout_ln;
	}
	public void setCheckout_ln(String checkout_ln) {
		this.checkout_ln = checkout_ln;
	}
	public String getCheckout_email() {
		return checkout_email;
	}
	public void setCheckout_email(String checkout_email) {
		this.checkout_email = checkout_email;
	}
	public String getCheckout_phone() {
		return checkout_phone;
	}
	public void setCheckout_phone(String checkout_phone) {
		this.checkout_phone = checkout_phone;
	}
	public String getCheckout_company() {
		return checkout_company;
	}
	public void setCheckout_company(String checkout_company) {
		this.checkout_company = checkout_company;
	}
	public String getCheckout_country() {
		return checkout_country;
	}
	public void setCheckout_country(String checkout_country) {
		this.checkout_country = checkout_country;
	}
	public String getCheckout_city() {
		return checkout_city;
	}
	public void setCheckout_city(String checkout_city) {
		this.checkout_city = checkout_city;
	}
	public String getCheckout_zip() {
		return checkout_zip;
	}
	public void setCheckout_zip(String checkout_zip) {
		this.checkout_zip = checkout_zip;
	}
	public String getCheckout_address1() {
		return checkout_address1;
	}
	public void setCheckout_address1(String checkout_address1) {
		this.checkout_address1 = checkout_address1;
	}
	public String getCheckout_address2() {
		return checkout_address2;
	}
	public void setCheckout_address2(String checkout_address2) {
		this.checkout_address2 = checkout_address2;
	}
	@Override
	public String toString() {
		return "Address [checkout_fn=" + checkout_fn + ", checkout_ln=" + checkout_ln + ", checkout_email="
				+ checkout_email + ", checkout_phone=" + checkout_phone + ", checkout_company=" + checkout_company
				+ ", checkout_country=" + checkout_country + ", checkout_city=" + checkout_city + ", checkout_zip="
				+ checkout_zip + ", checkout_address1=" + checkout_address1 + ", checkout_address2=" + checkout_address2
				+ "]";
	}
	
}
