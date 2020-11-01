package com.suresh.chainresponsible;

public abstract class Employee {
	protected Employee supervisor;
	
	public void setNextSupervisor(Employee supervisor){
		this.supervisor = supervisor;
	}
	
	public abstract void applyLeave(String name, int numberOfDaysLeave);
}
