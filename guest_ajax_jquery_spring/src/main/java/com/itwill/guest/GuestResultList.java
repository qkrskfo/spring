package com.itwill.guest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="guest_list")
public class GuestResultList {
	private List<Guest> guestList;

	@XmlElement(name="guest")
	public List<Guest> getGuestList() {
		return guestList;
	}

	public void setGuestList(List<Guest> guestList) {
		this.guestList = guestList;
	}
	
}