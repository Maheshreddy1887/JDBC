package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Examplejdbc {

	public static void main(String[] args) {
		
		String username="root";
		String password="mahesh9232";
		String url="jdbc:mysql://localhost:3306/employee";
		
		try {
			
			Connection connect = DriverManager.getConnection(url, username, password);
			System.out.println(connect);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
