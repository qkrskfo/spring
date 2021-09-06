package com.mybatis3.dao;

public class AddressDaoMain {

	public static void main(String[] args) {
		/*******************AddressDao.findAddressById()**************/
		AddressDao addressDao = new AddressDao();
		System.out.println("###"+addressDao.findAddressByIdWithStudents(4));
		System.out.println("###"+addressDao.findAddressByIdWithStudents(8));
	}

}
