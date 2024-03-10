package com.jspiders.multithreading.resources;

public class Account {
	private double balance;
	
	public synchronized void deposit(double amount) {
		System.out.println("The amount credited to account is " + amount);
		balance += amount;
		System.out.println("Current Balance in Account is " + balance);
	}
	
	public synchronized void withdraw(double amount) {
		System.out.println("The amount debited from account is " + amount);
		balance -= amount;
		System.out.println("Current Balance in Account is " + balance);
	}
}
