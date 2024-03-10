package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resources.MyResource;
import com.jspiders.multithreading.thread.MyThread8;
import com.jspiders.multithreading.thread.MyThread9;

public class ThreadMain6 {

	public static void main(String[] args) {
		MyResource myResource = new MyResource();
		
		MyThread8 myThread8 = new MyThread8(myResource);
		myThread8.setName("MyThread8");
		
		MyThread9 myThread9 = new MyThread9(myResource);
		myThread9.setName("MyThread9");
				
		myThread8.start();
		myThread9.start();

	}

}
