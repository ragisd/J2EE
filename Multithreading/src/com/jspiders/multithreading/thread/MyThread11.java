package com.jspiders.multithreading.thread;

public class MyThread11 extends Thread{
	
	@Override
	public void run() {
		String message = "Java is Programming Language";
		char[] charArray = message.toCharArray();
	
		for(int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
