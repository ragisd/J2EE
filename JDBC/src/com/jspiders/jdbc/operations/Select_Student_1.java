package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select_Student_1 {

	private static Connection connection; 
	private static String query;
	private static Statement statement; 
	private static ResultSet resultset;
	
	public static void main(String[] args) {
		
		int i = 1;
		
		try {
			openConnection();
			statement = connection.createStatement();
			query = "SELECT * FROM student WHERE name LIKE '%ay'";
			statement.execute(query);
			resultset = statement.getResultSet();
			while(resultset.next()) {
				System.out.println("Record " + i + " => ");
				System.out.println("Id - " + resultset.getInt(1));
				System.out.println("Name - " + resultset.getString(2));
				System.out.println("Email - " + resultset.getString(3));
				System.out.println("Age - " + resultset.getInt(4));
				i++;
			}
			
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
