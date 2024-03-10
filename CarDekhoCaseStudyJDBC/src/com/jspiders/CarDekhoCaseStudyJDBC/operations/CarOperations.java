package com.jspiders.CarDekhoCaseStudyJDBC.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jspiders.CarDekhoCaseStudyJDBC.entity.Car;

public class CarOperations {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String query;
	private static String query2;
	
	
	public int totalRecords() {
		
		int count = 0;
		
		try {
			openConnection();
			query2 = "SELECT COUNT(*) FROM cars";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query2);
			if(resultSet.next()) {
				count = resultSet.getInt(1);
			}
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
		
		return count;
	}
	
	public boolean checkRecords(int id) {
		
		boolean count = false;
		
		try {
			openConnection();
			query2 = "SELECT * FROM cars";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query2);
			while(resultSet.next()) {
				if(id == resultSet.getInt(1)) {
					count = true;
					break;
				}
			}
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
		
		return count;
	}
	
	
	public void addCar(Scanner scanner) {
		
		 
		Car car = new Car();
		System.out.println("Enter car id : ");
		int id = scanner.nextInt();
		scanner.nextLine();
		car.setId(id);
		System.out.println("Enter car name : ");
		String name = scanner.nextLine();
		car.setName(name);
		System.out.println("Enter car price : ");
		int price = scanner.nextInt();
		car.setPrice(price);
		System.out.println("Enter color of the car : ");
		String color = scanner.next();
		car.setColor(color);
		
		try {
			openConnection();
			query = "INSERT INTO cars VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, price);
			preparedStatement.setString(4, color);
			preparedStatement.executeUpdate();
			
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
		
		System.out.println("Car added");
	}
	
	public void displayAllCars(Scanner scanner) {
		
		int i = 1;
		Car car = new Car();
				
		try {
			openConnection();
			query = "SELECT * FROM cars";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println("Record " + i);
				System.out.println("Id => " + resultSet.getInt(1));
				System.out.println("Name => " + resultSet.getString(2));
				System.out.println("Price => " + resultSet.getInt(3));
				System.out.println("Color => " + resultSet.getString(4));
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
	
	public void displayCarById(Scanner scanner) {
				
		try {
			System.out.println("Enter Id of the car : ");
			int id = scanner.nextInt();
			
			if(checkRecords(id)) {
				openConnection();
				query = "SELECT * FROM cars WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					if(resultSet.getInt(1) == id) {
						System.out.println("Id => " + resultSet.getInt(1));
						System.out.println("Name => " + resultSet.getString(2));
						System.out.println("Price => " + resultSet.getInt(3));
						System.out.println("Color => " + resultSet.getString(4));
						break;
					}
				}
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
	
	public void deleteCarById(Scanner scanner) {
		
		try {
			System.out.println("Enter Id of the car : ");
			int id = scanner.nextInt();
			
			if(checkRecords(id)) {
				openConnection();
				query = "DELETE FROM cars WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, id);
				System.out.println("Record deleted successfully");
			}
			else
				System.out.println("Record not present");
						
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
	
	public void updateCarPrice(Scanner scanner) {
		
		System.out.println("Enter Id of the car : ");
		int id = scanner.nextInt();
		System.out.println("Enter new price of the car : ");
		int price = scanner.nextInt();
				
		try {
			if(checkRecords(id)) {
				openConnection();
				query = "UPDATE cars SET price = ? WHERE id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, price);
				preparedStatement.setInt(2, id);
				preparedStatement.executeUpdate();
				System.out.println("Price updated succesfully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

