package com.jspiders.designpatterns.creational;

public class Contact {

	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private long mobile;
	private long work;
	private long home;
	private int landline;
	private String email;
	private String website;

	public Contact(String firstName, String lastName, String dob, String gender, long mobile, 
			       long work, long home, int landline, String email, String website) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		this.work = work;
		this.home = home;
		this.landline = landline;
		this.email = email;
		this.website = website;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob 
				+ ", gender=" + gender + ", mobile=" + mobile + ", work=" + work + ", home=" + home 
				+ ", landline=" + landline + ", email=" + email + ", website=" + website + "]";
	}

}
