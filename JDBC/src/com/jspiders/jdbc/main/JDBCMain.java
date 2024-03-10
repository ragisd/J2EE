package com.jspiders.jdbc.main;

import java.util.Scanner;

import com.jspiders.jdbc.operations.JDBCService;

public class JDBCMain {

	public static void main(String[] args) {
		
		Boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 1 to Sign Up \n Enter 2 to Log In \n Enter 3 to Exit.");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			JDBCService.signUp(scanner);
			break;
		case 2:
			JDBCService.logIn(scanner);
			break;
		
		default:
			System.out.println("Invalid choice");
			break;
		}

	}

}
