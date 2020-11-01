package com.suresh.flyweightaddressbook;

public class PersonFlyWeightDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactDetails contact = (ContactDetails) PersonFactory.getPerson("contactdetail");
		contact.setName("Suresh Kumar");
		contact.setEmailAddress("suresh84mca@gmail.com");
		contact.setPhone("9376266971");
		contact.setZipCode("45342");
		contact.displayPerson();
		
		ContactDetails c1 = (ContactDetails) PersonFactory.getPerson("contactdetail");
		c1.setName("Kumar");
		c1.setEmailAddress("manisx@gmail.com");
		c1.setPhone("9376254781");
		c1.setZipCode("45342");
		c1.displayPerson();
		
		ContactDetails c2 = (ContactDetails) PersonFactory.getPerson("contactdetail");
		c2.setName("Bhuvee");
		c2.setEmailAddress("bhuvee@gmail.com");
		c2.setPhone("9375677815");
		c2.setZipCode("45342");
		c2.displayPerson();
	}

}
