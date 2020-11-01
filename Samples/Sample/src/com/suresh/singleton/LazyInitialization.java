package com.suresh.singleton;

public class LazyInitialization {
	
	private LazyInitialization() {}
	
	private static LazyInitialization instance;
	
	public static LazyInitialization getInstance(){
		if(instance == null){
			instance = new LazyInitialization();
		}
		
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LazyInitialization obj = LazyInitialization.getInstance();
		System.out.println(obj.hashCode());
		
		LazyInitialization obj1 = LazyInitialization.getInstance();
		System.out.println(obj1.hashCode());

	}

}
