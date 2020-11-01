package com.suresh.singleton;

public class DoubleCheckingSingleton {
	private DoubleCheckingSingleton() {
	}

	private static DoubleCheckingSingleton instance;

	public static DoubleCheckingSingleton getInstance() {

		if (instance == null) {
			synchronized (DoubleCheckingSingleton.class) {
				if (instance == null)
					instance = new DoubleCheckingSingleton();
			}
		}
		
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleCheckingSingleton obj = DoubleCheckingSingleton.getInstance();
		System.out.println(obj.hashCode());

		DoubleCheckingSingleton obj1 = DoubleCheckingSingleton.getInstance();
		System.out.println(obj1.hashCode());

	}

}
