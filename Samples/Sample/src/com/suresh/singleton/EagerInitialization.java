package com.suresh.singleton;

public class EagerInitialization {

	private static final EagerInitialization instance = new EagerInitialization();

	private EagerInitialization() {
	}

	public static EagerInitialization getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EagerInitialization obj = EagerInitialization.getInstance();
		EagerInitialization obj1 = EagerInitialization.getInstance();
		System.out.println(obj.hashCode());
		System.out.println(obj1.hashCode());
	}
}
