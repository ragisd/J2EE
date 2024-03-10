package com.jspiders.CarDekhoCaseStudyJDBC.main;

import java.util.Scanner;

import com.jspiders.CarDekhoCaseStudyJDBC.operations.CarOperations;

public class CarMain {
	
	private static CarOperations carOperation = new CarOperations();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
//		carOperation.totalRecords();
		
		boolean flag = true;
		while (flag) {
			System.out.println(
					"Enter 1 to add a car\nEnter 2 to search car by id\nEnter 3 to fetch all cars\nEnter 4 to delete a car\nEnter 5 to update car price\nEnter 6 to exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				carOperation.addCar(scanner);
				break;
			case 2:
				carOperation.displayCarById(scanner);
				break;
			case 3:
				carOperation.displayAllCars(scanner);
				break;
			case 4:
				carOperation.deleteCarById(scanner);
				break;
			case 5:
				carOperation.updateCarPrice(scanner);
				break;
			case 6:
				flag = false;
				System.out.println("Thank You");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
		scanner.close();

		
				
	}
	
	

}
