package com.xworkz.jdbc;

public class Laptop {

	public static void main(String[] args) {

		LaptopDAOImpl laptopDAOImpl = new LaptopDAOImpl();
		// laptopDAOImpl.saveLaptopDetails();
		// laptopDAOImpl.saveLaptopDetails(10,"mahesh",9);
		// laptopDAOImpl.updateLaptopDetails("mahesh",9);
//			laptopDAOImpl.updateLaptopDetails();
//			laptopDAOImpl.deleteLaptopDetails();
//			laptopDAOImpl.readAllRecords();
		laptopDAOImpl.deleteLaptopDetails(5);
	}

}
