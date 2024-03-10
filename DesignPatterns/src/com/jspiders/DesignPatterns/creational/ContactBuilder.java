package com.jspiders.DesignPatterns.creational;

public class ContactBuilder {
	
	private String firstName;
	private String lastName;
	private long mobileNo;
	private long workNo;
	private long landline;
	private String email;
	private String address;
	private String website;
	
	public ContactBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public ContactBuilder setlastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public ContactBuilder setmobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
		return this;
	}
	public ContactBuilder setworkNo(long workNo) {
		this.workNo = workNo;
		return this;
	}
	public ContactBuilder setlandline(long landline) {
		this.landline = landline;
		return this;
	}
	public ContactBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	public ContactBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	public ContactBuilder setWebsite(String website) {
		this.website = website;
		return this;
	}
	
	public Contact getObject() {
		return new Contact(firstName, lastName, mobileNo, workNo, landline, address, email, website);
	}

	
}
