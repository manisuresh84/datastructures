package com.suresh.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {
	private List<String> empList;
	public Employee(){
		empList = new ArrayList<String>();
	}
	
	public Employee(List<String> list){
		this.empList = list;
	}
	
	public void loadData(){
		empList.add("Kumar");
		empList.add("Suresh");
		empList.add("Sai");
		empList.add("Bhuvee");
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
	
		List<String> temp = new ArrayList<String>();
		for(String s: this.getEmpList()){
			temp.add(s);
		}
		
		return new Employee(temp);
	}

	public List<String> getEmpList() {
		return empList;
	}	
}
