package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect {

		private static Connection connection;
		private static Statement statement;
		private static String query;
		private static ResultSet resultset;
	
		public static void main(String[] args) {
			
			try {
				openConnection();
				statement = connection.createStatement();
				query = "SELECT * FROM user";
				statement.execute(query);
				resultset = statement.getResultSet();
				while(resultset.next()) {
					System.out.println(resultset.getInt(1));
					System.out.println(resultset.getString(2));
					System.out.println(resultset.getString(3));
					System.out.println(resultset.getString(4));
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
			
			if(statement != null) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
}
