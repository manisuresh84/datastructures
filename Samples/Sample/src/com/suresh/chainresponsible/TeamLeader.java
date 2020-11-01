package com.suresh.chainresponsible;

public class TeamLeader extends Employee {
	private final int MAX_APPROVE_LEAVE = 10; 
	public void approveLeave(String name, int numberOfDays){
		System.out.println("Team Leader approved, " + name + " for " + numberOfDays + " days leave");
	}
	
	@Override
	public void applyLeave(String name, int numberOfDaysLeave) {
		// TODO Auto-generated method stub
		if(numberOfDaysLeave < MAX_APPROVE_LEAVE){
			approveLeave(name, numberOfDaysLeave);
		}
		else{
			supervisor.applyLeave(name, numberOfDaysLeave);
		}
		
	}

}
