package com.xworkz.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.laptop.Laptop;
import com.xworkz.laptop.entity.LaptopEntity;
import com.xworkz.ConnectionProvider;

public class LaptopDAOImpl {
	public void savelaptopRecord(LaptopEntity laptopEntity) {
		System.out.println("invoked savelaptopRecord");
		String insertQuery = "INSERT into  Laptop  VALUE(?,?,?,?,?,?,?,?,?,?)";

		try {
			Connection connection = ConnectionProvider.getConnection();
			// pass the query
			PreparedStatement preparedstatement = connection.prepareStatement(insertQuery);
			// set the values using setters
			preparedstatement.setInt(1, laptopEntity.getId());
			preparedstatement.setString(2, laptopEntity.getBrand());
			preparedstatement.setString(3, laptopEntity.getColor());
			preparedstatement.setDouble(4, laptopEntity.getPrice());
			preparedstatement.setInt(5, laptopEntity.getRam());
			preparedstatement.setString(6, laptopEntity.getProcessor());
			preparedstatement.setBoolean(7, laptopEntity.isIs_Camera_Present());
			preparedstatement.setString(8, laptopEntity.getScreen_Size());
			preparedstatement.setInt(9, laptopEntity.getWeight());
			preparedstatement.setBoolean(10, laptopEntity.isIs_Cd_Supported());
			preparedstatement.executeUpdate();
			System.out.println("Laptop Record is Saved Sucessfully");

		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}

	}

	public void updateBrand(LaptopEntity laptopEntity) {
		System.out.println("Invoked UpdateBrandRecord");
		String UpdateBrand = "UPDATE Laptop set Brand = ? where id = ?";

		try {
			Connection connection = ConnectionProvider.getConnection();
			// pass the query
			PreparedStatement preparedstatement = connection.prepareStatement(UpdateBrand);
			// set the values using setters
			preparedstatement.setString(1, laptopEntity.getBrand());
			preparedstatement.setInt(2, laptopEntity.getId());
			preparedstatement.executeUpdate();
			System.out.println("Laptop Update is Saved Sucessfully");

		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}

	}

	public void deleteLaptopbyId(LaptopEntity laptopEntity) {
		System.out.println("invoked deleteLaptopById Record");
		String deleteQuery = "delete from laptop WHERE id=?";

		try {
			Connection connection = ConnectionProvider.getConnection();
			// pass the query
			PreparedStatement preparedstatement = connection.prepareStatement(deleteQuery);
			// set the values using setters
			preparedstatement.setInt(1, laptopEntity.getId());
			preparedstatement.executeUpdate();
			System.out.println("Laptop from id deleted Sucessfully");

		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}

	}

	public LaptopEntity readSingleRecordById(LaptopEntity laptopEntity) {
		System.out.println("invoked readSingleRecordById");
		String readSingleRecordById = "SELECT * FROM Laptop WHERE  id=?";

		try {
			Connection connection = ConnectionProvider.getConnection();
			// pass the query
			PreparedStatement preparedstatement = connection.prepareStatement(readSingleRecordById);
			// set the values using setters
			preparedstatement.setInt(1, laptopEntity.getId());
			ResultSet resultset = preparedstatement.executeQuery();
			resultset.next();
			System.out.println("id " + preparedstatement.getResultSet().getInt(1));
			System.out.println("Brand " + preparedstatement.getResultSet().getString(2));
			System.out.println("Color " + preparedstatement.getResultSet().getString(3));
			System.out.println("Price " + preparedstatement.getResultSet().getDouble(4));
			System.out.println("Ram " + preparedstatement.getResultSet().getInt(5));
			System.out.println("Processor " + preparedstatement.getResultSet().getString(6));
			System.out.println("Is_Camera_Present " + preparedstatement.getResultSet().getBoolean(7));
			System.out.println("Screen_Size " + preparedstatement.getResultSet().getString(8));
			System.out.println("Weight " + preparedstatement.getResultSet().getInt(9));
			System.out.println("Is_Cd_Supported " + preparedstatement.getResultSet().getBoolean(10));
			System.out.println("Single Line Record by ID Readed Sucessfully");

		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}
		return laptopEntity;

	}

	public List<LaptopEntity> readAllRecord() {
		System.out.println("invoked readAllRecordById");
		String readAllRecord = "SELECT * FROM laptop.laptop; ";
		List<LaptopEntity> container = new ArrayList<LaptopEntity>();
		LaptopEntity laptopEntity = null;
		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement(readAllRecord);
			// *boolean isRowPresent = resultSet.next();
			// *while(isRowPresent)

			ResultSet resultset = preparedstatement.executeQuery(readAllRecord);
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String brand = resultset.getString(2);
				String color = resultset.getString(3);
				double price = resultset.getDouble(4);
				int Ram = resultset.getInt(5);
				String Processor = resultset.getString(6);
				boolean Is_Camera_Present = resultset.getBoolean(7);
				String Screen_Size = resultset.getString(8);
				int Weight = resultset.getInt(9);
				boolean Is_Cd_Supported = resultset.getBoolean(10);

				laptopEntity = new LaptopEntity(id, brand, color, price, Ram, Processor, Is_Camera_Present, Screen_Size,
						Weight, Is_Cd_Supported);
				container.add(laptopEntity);
			}
		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}
		return container;

	}

	public void readlaptopPriceById(LaptopEntity laptopEntity) {
		System.out.println("invoked readlaptopPriceById");
		String readlaptopPriceById = "select price FROM Laptop WHERE id=?";

		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement(readlaptopPriceById);
			preparedstatement.setInt(1, laptopEntity.getId());
			ResultSet resultset = preparedstatement.executeQuery();
			resultset.next();
			System.out.println("Price " + preparedstatement.getResultSet().getInt(1));
			System.out.println("Laptop Price by ID is Readed  Sucessfully");

		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}
	}

	public void readLaptopBrandById(LaptopEntity laptopEntity) {
		System.out.println("invoked readLaptopBrandById");
		String readLaptopBrandById = "select Brand FROM Laptop WHERE id=?";

		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement(readLaptopBrandById);
			preparedstatement.setInt(1, laptopEntity.getId());
			ResultSet resultset = preparedstatement.executeQuery();
			resultset.next();

			System.out.println("Brand " + preparedstatement.getResultSet().getString(1));
			System.out.println("Laptop Brand by ID is Readed  Sucessfully");

		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}
	}

	public void readLaptopColorById(LaptopEntity laptopEntity) {
		System.out.println("readLaptopColorById");
		String readLaptopColorById = "select Color FROM Laptop WHERE id=?";

		try {
			Connection connection = ConnectionProvider.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement(readLaptopColorById);
			preparedstatement.setInt(1, laptopEntity.getId());
			ResultSet resultset = preparedstatement.executeQuery();
			resultset.next();
			System.out.println("Color " + preparedstatement.getResultSet().getString(1));
			System.out.println("Laptop Color FROM Id is Readed  Sucessfully");

		} catch (SQLException sqlException) {
			System.out.println("Inside catch black Exception");
			System.out.println(sqlException.getMessage());
			sqlException.printStackTrace();
		}

	}

}