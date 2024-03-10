package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resources.Food;

public class Restaurant extends Thread {
	private Food food;
	
	public Restaurant(Food food) {
		this.food = food;
	}
	@Override
	public void run() {
		food.prepare();
	}
	
}
