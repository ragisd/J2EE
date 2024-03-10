package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert4 {
	
	private static Connection connection; 
	private static String query;
	private static Statement statement; 
	
	public static void main(String[] args) {
		
		try {
			openConnection();
			statement = connection.createStatement();
			query = "INSERT INTO student VALUES(5, 'Vijay', 'vijay@gmail.com', 31)";
			statement.execute(query);
			System.out.println("data inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
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
		if(statement != null) {
			statement.close();
		}
	}

}
