package com.jspiders.DesignPatterns.main;

import com.jspiders.DesignPatterns.creational.Contact;
import com.jspiders.DesignPatterns.creational.ContactBuilder;

public class BuilderMain {

	public static void main(String[] args) {
		
		Contact contact = new ContactBuilder().setFirstName("cade").setlandline(9753827827638l).getObject();
		
		System.out.println(contact);
		
	}

}
