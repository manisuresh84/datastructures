package com.suresh.chainresponsible;

public class ChainOfResponsiblityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamLeader t = new TeamLeader();
		ProjectLeader p = new ProjectLeader();
		HR h = new HR();
		
		t.setNextSupervisor(p);
		p.setNextSupervisor(h);
		
		t.applyLeave("Suresh", 8);
		t.applyLeave("Sai", 19);
		t.applyLeave("Kumar", 28);
		t.applyLeave("Manisx", 40);
	}

}
