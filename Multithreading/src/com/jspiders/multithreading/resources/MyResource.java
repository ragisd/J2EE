package com.jspiders.multithreading.resources;

public class MyResource {
	public void resource() {
		System.out.println("lock is applied on resource by " + Thread.currentThread().getName());
	}
}
