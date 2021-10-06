package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc2 {

	public static void main(String[] args) {
		String username="root";
		String password="mahesh9232";
		String url="Jdbc:mysql://localhost:3306/employee";
		
		try {
			Connection mahesh=DriverManager.getConnection(url,username,password);
			System.out.println(mahesh);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	}


