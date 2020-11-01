package com.suresh.singleton;

public class StaticBlockInitialization {
	private static StaticBlockInitialization instance;

	static {
		try {
			instance = new StaticBlockInitialization();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private StaticBlockInitialization() {
	}

	public static StaticBlockInitialization getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticBlockInitialization obj = StaticBlockInitialization.getInstance();
		System.out.println(obj.hashCode());

		StaticBlockInitialization obj1 = StaticBlockInitialization.getInstance();
		System.out.println(obj1.hashCode());

	}

}
