package com.service.user;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MyApplication extends Application{

	@Override
	
	public Set<Class<?>> getClasses(){

		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(UserServices.class);
		s.add(MyMessageBodyReader.class);
		s.add(MyMessageBodyWriter.class);
		s.add(JSONService.class);
		return s;
	}
}
