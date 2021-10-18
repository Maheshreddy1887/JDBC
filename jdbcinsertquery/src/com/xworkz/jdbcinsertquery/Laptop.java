package com.xworkz.jdbcinsertquery;
import java.sql.*;
public class Laptop {

	public static void main(String[] args) {
		

				String url="jdbc:mysql://localhost:3306/Laptop";
				String userName = "root";
				String password = "mahesh9232";
				Connection connection=null;
				String insertQuery = "INSERT INTO laptop_details values('dell','white',5,40000,3)";


				try {
					connection = DriverManager.getConnection(url, userName, password);
					System.out.println("connection is suceesfull" + url);

					Statement statement = connection.createStatement();
					statement.executeUpdate(insertQuery);
					System.out.println("Data Inserted  Sucessfully");

				}catch(SQLException e) {

					System.out.println(e.getMessage());
				}
				finally {
					if(connection != null) {
						System.out.println("connection closed");
						System.out.println("------------------");
					}
					else {
						System.out.println("connection is not closed");
					}

				}

			}

	}


