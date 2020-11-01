package com.suresh.flyweightaddressbook;

import java.util.HashMap;

public class PersonFactory {
	private static HashMap<String, Person> personMap = new HashMap<String, Person>();

	public static Person getPerson(String type) {
		Person person = null;
		if (type.equalsIgnoreCase("contactdetail")) {
			person = personMap.get("contactdetail");
			if (person == null) {
				person = new ContactDetails();
				personMap.put("contactdetail", person);
			}
		}
		return person;
	}
}
