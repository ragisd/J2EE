package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert3 {
	
	private static Connection connection; 
	private static String query;
	private static PreparedStatement preparedStatement;  

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of the person : ");
		int id = scanner.nextInt();
		System.out.println("Enter name of the person : ");
		String name = scanner.next();
		System.out.println("Enter email of the person : ");
		String email = scanner.next();
		System.out.println("Enter password of the person : ");
		String password = scanner.next();
		scanner.close();
		
		try {
			openConnection();
	
			query = "INSERT INTO user VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " rows(s) affected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
