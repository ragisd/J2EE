package com.jspiders.DesignPatterns.main;

import com.jspiders.DesignPatterns.structural.Adapter;

public class AdapterMain {

	public static void main(String[] args) {
		
		Adapter adapter = new Adapter();
		
		adapter.setName("rama");
		adapter.womensDay();
		adapter.setName("ram");
		adapter.mensDay();
		
		
	}

}
