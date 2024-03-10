package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBSInsert5 {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			query = "INSERT INTO user VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("How many records do you want to insert ?");
			int count = scanner.nextInt();
			for(int i = 1; i <= count; i++) {
				System.out.println("Enter id of the person : ");
				int id = scanner.nextInt();
				System.out.println("Enter name of the person : ");
				String name = scanner.next();
				System.out.println("Enter email of the person : ");
				String email = scanner.next();
				System.out.println("Enter password of the person : ");
				String password = scanner.next();
				
				preparedStatement.setInt(1,id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, email);
				preparedStatement.setString(4, password);
				
				preparedStatement.addBatch();
				
			}
			
			scanner.close();
			int[] res = preparedStatement.executeBatch();
			System.out.println(res.length + " row(s) affected.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static void openConnection() throws SQLException {
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
