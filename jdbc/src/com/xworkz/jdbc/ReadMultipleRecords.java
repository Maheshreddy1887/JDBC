package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadMultipleRecords {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/students";
		String userName = "root";
		String password = "mahesh9232";
		String readMultipleRecordQuery = "select * from student_details";
		Connection connection = null;

		try {

			connection = DriverManager.getConnection(url, userName, password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(readMultipleRecordQuery);

			resultSet.next();
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");
			System.out.print(resultSet.getInt(3) + " ");

			System.out.println();
			System.out.println("-----------second row data--------------");

			resultSet.next();
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");
			System.out.print(resultSet.getInt(3) + " ");

			System.out.println();
			System.out.println("-----------third row data--------------");

			resultSet.next();
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");
			System.out.print(resultSet.getInt(3) + " ");

			System.out.println();
			System.out.println("-----------Fourth row data--------------");

			resultSet.next();
			System.out.print(resultSet.getInt(1) + " ");
			System.out.print(resultSet.getString(2) + " ");
			System.out.print(resultSet.getInt(3) + " ");
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}
	}

}
