package com.jspiders.PracticePrograms.patterns;

public class Contact {

	private String firstName;
	private String lastName;
	private long mobileNo;
	private long workNo;
	private long landline;
	private String email;
	private String address;
	private String website;
	
	public Contact(String firstName, String lastName, long mobileNo, long workNo, long landline, String email,
			String address, String website) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.workNo = workNo;
		this.landline = landline;
		this.email = email;
		this.address = address;
		this.website = website;
	}
	
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo + ", workNo="
				+ workNo + ", landline=" + landline + ", email=" + email + ", address=" + address + ", website="
				+ website + "]";
	}
}
