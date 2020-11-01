package com.service.user;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;

public class SpecialUser {

	@PUT
	public void createSpecialUser(){
		
	}
	
	@GET
	public void getSpecialUser(){
		System.out.println("Inside SpecialUser/getSpecialUser Method");
	}
}
