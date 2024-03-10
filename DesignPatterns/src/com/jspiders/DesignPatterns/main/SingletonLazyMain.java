package com.jspiders.DesignPatterns.main;

import com.jspiders.DesignPatterns.creational.SingletonLazy;

public class SingletonLazyMain {

	public static void main(String[] args) {
		
		SingletonLazy singletonLazy = SingletonLazy.getObject();
		SingletonLazy singletonLazy1 = SingletonLazy.getObject();
		
		System.out.println(singletonLazy);
		System.out.println(singletonLazy1);

	}

}
