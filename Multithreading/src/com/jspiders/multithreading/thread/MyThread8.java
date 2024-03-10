package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resources.MyResource;

public class MyThread8 extends Thread{
	private MyResource myResource1 = new MyResource();
	
	public MyThread8(MyResource myResource1) {
		this.myResource1 = myResource1;
	}
	public void run() {
		myResource1.resource();
	}
}
