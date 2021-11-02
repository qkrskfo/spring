package com.itwill.shop.user;

/**
 * @author TEA
 *
 */
public class Account {
	private String account_fn;
	private String account_ln;
	private String account_email;
	private String account_phone;
	private String account_pass;
	private String account_confirm_pass;
	public Account() {
		System.out.println(this);
	}
	public String getAccount_fn() {
		return account_fn;
	}
	public void setAccount_fn(String account_fn) {
		this.account_fn = account_fn;
	}
	public String getAccount_ln() {
		return account_ln;
	}
	public void setAccount_ln(String account_ln) {
		this.account_ln = account_ln;
	}
	public String getAccount_email() {
		return account_email;
	}
	public void setAccount_email(String account_email) {
		this.account_email = account_email;
	}
	public String getAccount_phone() {
		return account_phone;
	}
	public void setAccount_phone(String account_phone) {
		this.account_phone = account_phone;
	}
	public String getAccount_pass() {
		return account_pass;
	}
	public void setAccount_pass(String account_pass) {
		this.account_pass = account_pass;
	}
	public String getAccount_confirm_pass() {
		return account_confirm_pass;
	}
	public void setAccount_confirm_pass(String account_confirm_pass) {
		this.account_confirm_pass = account_confirm_pass;
	}
	@Override
	public String toString() {
		return "Account [account_fn=" + account_fn + ", account_ln=" + account_ln + ", account_email=" + account_email
				+ ", account_phone=" + account_phone + ", account_pass=" + account_pass + ", account_confirm_pass="
				+ account_confirm_pass + "]";
	}
	
	
}
