package com.suresh.singleton;

public class InnerStaticClassSingleton {

	private InnerStaticClassSingleton() {}
	
	private static class InnerStaticHelper{
		private static final InnerStaticClassSingleton instance = new InnerStaticClassSingleton();
	}
	
	public static InnerStaticClassSingleton getInstance(){
		return InnerStaticHelper.instance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerStaticClassSingleton obj = InnerStaticClassSingleton.getInstance();
		System.out.println(obj.hashCode());
		
		InnerStaticClassSingleton obj1 = InnerStaticClassSingleton.getInstance();
		System.out.println(obj1.hashCode());
	}

}
