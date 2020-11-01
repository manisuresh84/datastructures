package com.suresh.mediator;

public class MediatorPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FacebookGroupMediator mediator = new FacebookGroupMediatorImpl();
		User dave = new UserImpl(mediator, "Dave");
		User suresh = new UserImpl(mediator, "Suresh");
		User sai = new UserImpl(mediator, "Sai");
		
		mediator.registerUser(dave);
		mediator.registerUser(suresh);
		mediator.registerUser(sai);
		
		dave.send("My Reference Material!!");
		
		System.out.println("------------------------------------");
		
		suresh.send("Hi all...");
	}

}
