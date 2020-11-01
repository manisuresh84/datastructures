package com.suresh.mediator;

public class UserImpl extends User{

	public UserImpl(FacebookGroupMediator mediator, String name) {
		super(mediator, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		System.out.println(this.name + ": Sending Message=" + msg + "\n");
		mediator.sendMessage(msg, this);
		
	}

	@Override
	public void receive(String msg) {
		// TODO Auto-generated method stub
		System.out.println(this.name + ": Received Message:" + msg +"\n");
		
	}
}
