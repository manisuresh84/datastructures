package com.suresh.chainresponsible;

public class HR extends Employee {
	private final int MAX_APPROVE_LEAVE = 30;
	public void approveLeave(String name, int numberOfDaysLeave){
		System.out.println("HR Manager approved, " + name + " for " + numberOfDaysLeave + " days leave");
	}
	@Override
	public void applyLeave(String name, int numberOfDaysLeave) {
		// TODO Auto-generated method stub
		if(numberOfDaysLeave < MAX_APPROVE_LEAVE){
			approveLeave(name, numberOfDaysLeave);
		}else{
			System.out.println(name + " your Leave Request is suspended.... Please contact HR Manager!!");
		}
	}
}
