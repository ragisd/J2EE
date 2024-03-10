package com.jspiders.multithreading.resources;

public class Food {
	private boolean available;
	
	public synchronized void order() {
		System.out.println("Order is recieved");
		if(available) {
			System.out.println("order os delivered");
		}
		else {
			System.out.println("food is not prepared");
			System.out.println("wait for some time...");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(available) {
				System.out.println("order is delivered");
			}
		}
	}
	
	public synchronized void prepare() {
		System.out.println("food is being prepared");
		System.out.println("food is prepared");
		available = true;
		notify();
	}
}
