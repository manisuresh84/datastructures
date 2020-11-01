package com.suresh.mediator;

import java.util.ArrayList;
import java.util.List;

public class FacebookGroupMediatorImpl implements FacebookGroupMediator {
	List<User> userList;
	
	public FacebookGroupMediatorImpl() {
		userList = new ArrayList<User>(); 
	}

	@Override
	public void sendMessage(String str, User user) {
		// TODO Auto-generated method stub
		for(User u : this.userList){
			if(u != user){
				u.receive(str);
			}
		}
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		this.userList.add(user);
		
	}

}
