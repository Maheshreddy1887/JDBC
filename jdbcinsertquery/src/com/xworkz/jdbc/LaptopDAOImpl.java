package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.jdbc.ConnectionProvider;

public class LaptopDAOImpl implements LaptopDAO {

	public void saveLaptopDetails() {

		String insertQuery = "INSERT INTO Laptop_details values(5,'DELL',10)";

		try {

			Statement statement = ConnectionProvider.getConnection().createStatement();
			statement.executeUpdate(insertQuery);
			System.out.println("Data inserted successfully");
			System.out.println("closing connection");
			ConnectionProvider.closeDbConnection();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (NullPointerException nullPointerException) {
			System.out.println("connection unsuccessfull");
		}
	}

	public void updateLaptopDetails() {

		String updateQuery = "update Laptop_details set student_name='gabriel' where student_rollno=6";

		try {

			Statement statement = ConnectionProvider.getConnection().createStatement();
			statement.executeUpdate(updateQuery);
			System.out.println("Data Updated successfully");
			System.out.println("closing connection");
			ConnectionProvider.closeDbConnection();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (NullPointerException nullPointerException) {
			System.out.println("connection unsuccessfull");
		}
	}

	public void deleteLaptopDetails() {

		String deleteQuery = "delete from Laptop_details where student_rollno=3";

		try {

			Statement statement = ConnectionProvider.getConnection().createStatement();
			statement.executeUpdate(deleteQuery);
			System.out.println("Data Deleted successfully");
			System.out.println("closing connection");
			ConnectionProvider.closeDbConnection();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (NullPointerException nullPointerException) {
			System.out.println("connection unsuccessfull");
		}

	}

	public void readAllRecords() {

		String readSingleRecordQuery = "select * from Laptop_details";
		try {

			Statement statement = ConnectionProvider.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(readSingleRecordQuery);

			while (resultSet.next()) {
				System.out.println();
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getInt(3) + " ");
			}
			System.out.println("closing connection");
			ConnectionProvider.closeDbConnection();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (NullPointerException nullPointerException) {
			System.out.println("connection unsuccessfull");
		}

	}

	public void saveLaptopDetails(int LaptopId, String LaptoptName, int LaptopClass) {

		String insertQuery = "INSERT INTO Laptop_details values(?,?,?)";

		try {

			PreparedStatement preparedstatement = ConnectionProvider.getConnection().prepareStatement(insertQuery);

			preparedstatement.setInt(1, LaptopId);
			preparedstatement.setString(2, LaptoptName);
			preparedstatement.setInt(3, LaptopClass);

			preparedstatement.executeUpdate();

			System.out.println("Data inserted successfully");
			System.out.println("closing connection");
			ConnectionProvider.closeDbConnection();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (NullPointerException nullPointerException) {
			System.out.println("connection unsuccessfull");
		}
	}

	public void updateLaptopDetails(String name, int rollno) {

		String updateQuery = "update Laptop_details set Laptop_name=? where Laptop_rollno=?";

		try {

			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(updateQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, rollno);

			preparedStatement.executeUpdate(updateQuery);
			System.out.println("Data Updated successfully");
			System.out.println("closing connection");
			ConnectionProvider.closeDbConnection();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (NullPointerException nullPointerException) {
			System.out.println("connection unsuccessfull");
		}
	}

	public void deleteLaptopDetails(int rollno) {

		String deleteQuery = "delete from Laptop_details where Laptop_rollno=?";

		try {

			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(deleteQuery);
			preparedStatement.setInt(1, rollno);
			preparedStatement.executeUpdate(deleteQuery);

			System.out.println("Data Deleted successfully");
			System.out.println("closing connection");
			ConnectionProvider.closeDbConnection();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} catch (NullPointerException nullPointerException) {
			System.out.println("connection unsuccessfull");
		}

	}

}
