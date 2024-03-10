package com.jspiders.PracticePrograms.patterns;


public class BuilderMain {

	public static void main(String[] args) {
		
		Contact contact = new ContactBuilder().setFirstName("cade").setlandline(9753827827638l).getObject();
		
		System.out.println(contact);

	}

}
