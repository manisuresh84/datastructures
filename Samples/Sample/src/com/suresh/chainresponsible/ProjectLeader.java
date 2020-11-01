package com.suresh.chainresponsible;

public class ProjectLeader extends Employee {
	
	private final int MAX_APPROVE_LEAVE = 20;
	
	public void approveLeave(String name, int numberOfDaysLeave){
		System.out.println("Project Leader approved, " + name + " for " + numberOfDaysLeave + " days leave");
	}

	@Override
	public void applyLeave(String name, int numberOfDaysLeave) {
		// TODO Auto-generated method stub
		if(numberOfDaysLeave < MAX_APPROVE_LEAVE){
			approveLeave(name, numberOfDaysLeave);
		}else{
			supervisor.applyLeave(name, numberOfDaysLeave);
		}
	}

}
