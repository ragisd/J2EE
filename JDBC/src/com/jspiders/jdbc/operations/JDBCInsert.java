package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Driver;

public class JDBCInsert {

	public static void main(String[] args) throws SQLException {
		
		//load and register the driver
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//open connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
		
		//create the statement
		Statement statement = connection.createStatement();
		
		//execute the statement
		statement.execute("INSERT INTO user VALUES(2, 'may', 'may@gmail.com', 'may21')");
		
		//process the result
		System.out.println("data inserted");
		
		//close the connection
		statement.close();
		connection.close();
		
		//deregister the driver
		DriverManager.deregisterDriver(driver);
		
	}
	
}
