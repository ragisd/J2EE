package com.jspiders.DesignPatterns.main;

import com.jspiders.DesignPatterns.creational.SingletonEager;

public class SingletonEagerMain {

	public static void main(String[] args) {
		
		SingletonEager singletonEager = SingletonEager.getObject();
		SingletonEager singletonEager1 = SingletonEager.getObject();
		
		System.out.println(singletonEager);
		System.out.println(singletonEager1);

	}

}
