package com.suresh.prototype;

import java.util.List;

public class PrototypeTestPattern {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Employee emps = new Employee();
		emps.loadData();
		
		Employee new1 = (Employee) emps.clone();
		Employee new2 = (Employee) emps.clone();
		
		List<String> list = new1.getEmpList();
		list.add("John");
		

		List<String> list1 = new2.getEmpList();
		list1.remove("Kumar");
		
		System.out.println("Original List :" + emps.getEmpList());
		System.out.println("New List 1    :" + list);
		System.out.println("New List 2    :" + list1);

	}

}
