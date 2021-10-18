package com.xworkz.jdbc;

import java.sql.SQLException;

public interface LaptopDAO {
	void saveLaptopDetails();

	void saveLaptopDetails(int LaptopId, String LaptopName, int LaptopClass);

	void updateLaptopDetails();

	void updateLaptopDetails(String name, int rollno);

	void deleteLaptopDetails();

	void deleteLaptopDetails(int rollno);

	void readAllRecords();
}
