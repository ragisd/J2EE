package com.jspiders.cardekhowithservlets.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class CarJDBC {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	private static int res = 0;

	public static int addCar(int id, String name, String brand, Long price) {
		
		try {
			openConnection();
			
			query = "INSERT INTO car VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, brand);
			preparedStatement.setLong(4, price);
			
			res = preparedStatement.executeUpdate();
			System.out.println(res + " rows(s) affected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	private static void openConnection() throws SQLException {
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver); 
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}
	
	private static void closeConnection() throws SQLException {
		
		if(connection != null) {
			connection.close();
		}
		if(preparedStatement != null) {
			preparedStatement.close();
		}
	}

}
