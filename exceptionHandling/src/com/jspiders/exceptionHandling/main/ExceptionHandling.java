package com.jspiders.exceptionHandling.main;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		try {
			int myInt = Integer.parseInt("pants");
			
		} catch (NumberFormatException e) {
			System.out.println("You can't make int out of it.");
			System.out.println(e);
		}
		
		// if try doesn't throw any exception then catch block is not executed.
		
		int a = 10;
		
		System.out.println(a);
		
		
		
	}

}
