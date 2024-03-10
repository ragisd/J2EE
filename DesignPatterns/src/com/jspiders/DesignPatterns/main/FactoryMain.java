package com.jspiders.DesignPatterns.main;

import java.util.Scanner;

import com.jspiders.DesignPatterns.creational.Beverage;
import com.jspiders.DesignPatterns.creational.GingerTea;
import com.jspiders.DesignPatterns.creational.GreenTea;
import com.jspiders.DesignPatterns.creational.LemonTea;
import com.jspiders.DesignPatterns.creational.MasalaTea;

public class FactoryMain {

	public static void main(String[] args) {
		
		factory().order();
	}	
		private static Beverage factory() {
			
			Beverage beverage = null;
			
			System.out.println("Enter 1 to order masala tea\nEnter 2 to order Green tea\nEnter 3 to order Lemon tea\nEnter 4 to order ginger tea");
			System.out.println("Enter your choice ");
			
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			scanner.close();
			
			switch(choice) {
			case 1 : beverage = new MasalaTea();
					 break;
			case 2 : beverage = new GreenTea();
			 		 break;
			case 3 : beverage = new LemonTea();
			 		 break;
			case 4 : beverage = new GingerTea();
			 		 break; 
			default: System.out.println("invalid choice");
			}
			
			return beverage;
		}

	}


