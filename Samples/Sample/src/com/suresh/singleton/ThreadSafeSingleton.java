package com.suresh.singleton;

public class ThreadSafeSingleton {

	private ThreadSafeSingleton() {}
	
	private static ThreadSafeSingleton instance;
	
	public static synchronized ThreadSafeSingleton getInstance(){
		if(instance == null){
			instance = new ThreadSafeSingleton();
		}
		
		return instance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadSafeSingleton obj = ThreadSafeSingleton.getInstance();
		System.out.println(obj.hashCode());

		ThreadSafeSingleton obj1 = ThreadSafeSingleton.getInstance();
		System.out.println(obj1.hashCode());
	}

}
