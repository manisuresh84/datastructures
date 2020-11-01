package com.suresh.flyweightaddressbook;

public class ContactDetails implements Person {
	String name;
	String emailAddress;
	String Phone;
	String zipCode;
	
	@Override
	public void displayPerson() {
		// TODO Auto-generated method stub
		System.out.println(this + " :Person Object Name [" + getName() + "] Email Address [" + getEmailAddress() + "] Phone [" + getPhone() + "] Zip Code [" + getZipCode() + "]");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
