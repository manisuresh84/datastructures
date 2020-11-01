package com.cognizant.tax;

public class TaxCalculator {
	float basicSalary;
	boolean citizenship;
	float tax;
	int nettSalary;
	
	public TaxCalculator(boolean citizenship, float basicSalary) {
		// TODO Auto-generated constructor stub
		this.citizenship = citizenship;
		this.basicSalary = basicSalary;
	}
	void calculateTax(){
		tax = 30*basicSalary/100;
		nettSalary = (int)tax;
		System.out.println("The Tax of the employee  for  the  " + basicSalary + " is " + tax);
	}
	
	void deductTax(){
		System.out.println("The nett salary of the employee" + nettSalary );
	}
	void validateSalary(){
		if(basicSalary > 100000 && citizenship == true){
			System.out.println("The salary and citizenship eligibility: true");
		}
		else{
			System.out.println("The salary and citizenship eligibility: false");
		}
	}
}
