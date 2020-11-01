package com.cognizant.tax;

public class EmployeeTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaxCalculator tc = new TaxCalculator(true, 25000);
		tc.calculateTax();
		tc.deductTax();
		tc.validateSalary();
		
		TaxCalculator tc1 = new TaxCalculator(true, 125000);
		tc1.calculateTax();
		tc1.deductTax();
		tc1.validateSalary();
	}

}
