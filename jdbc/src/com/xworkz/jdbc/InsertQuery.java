package com.xworkz.jdbc;

import java.sql.*;

public class InsertQuery {

	public static void main(String[] args) {

			
				String url= "jdbc:mysql://localhost:3306/Laptop";
				String userName= "root";
				String password= "mahesh9232";

				String insertquery1 = "INSERT INTO Details_laptop value ('hp',30000,'Intel Core-i5',1024)";
				String insertquery2 = "INSERT INTO Details_laptop value ('apple',58000,'Intel Core-i5',1024)";
				String insertquery3 = "INSERT INTO Details_laptop value ('dell',89000,'Intel Core-i7',1024)";
				String insertquery4= "INSERT INTO Details_laptop value ('Macbook',70000,'Intel Core-i7',1024)";

		try {
					Connection connection = DriverManager.getConnection(url, userName, password);
					System.out.println("Connection is Sucessfull with Database:"+url);
					Statement statement = connection.createStatement();

					statement.executeUpdate(insertquery3);
					statement.executeUpdate(insertquery4);
					statement.executeUpdate(insertquery2);

				} 
				catch (SQLException sqlException) {

					System.out.println(sqlException.getMessage());
					sqlException.printStackTrace();
				}

					catch (Exception classNotFoundException) {
						System.out.println(classNotFoundException.getMessage());

					}

		}

		

}


