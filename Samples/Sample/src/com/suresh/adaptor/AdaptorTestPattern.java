package com.suresh.adaptor;

public class AdaptorTestPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testClassAdaptor();
		testObjectAdaptor();
	}

	private static void testClassAdaptor() {
		SocketInterface s = new SocketClassImp();
		Volt v3 = getVolt(s, 3);
		Volt v12 = getVolt(s, 12);
		Volt v120 = getVolt(s, 120);
		
		System.out.println("V3 volts using class adaptor [" + v3.getVolts() + "]");
		System.out.println("V12 volts using class adaptor [" + v12.getVolts() + "]");
		System.out.println("V120 volts using class adaptor [" + v120.getVolts() + "]");
	}

	private static void testObjectAdaptor() {
		SocketInterface s1 = new SocketObjectImp();
		Volt v3 = getVolt(s1, 3);
		Volt v12 = getVolt(s1, 12);
		Volt v120 = getVolt(s1, 120);
		
		System.out.println("V3 volts using object adaptor [" + v3.getVolts() + "]");
		System.out.println("V12 volts using object adaptor [" + v12.getVolts() + "]");
		System.out.println("V120 volts using object adaptor [" + v120.getVolts() + "]");
	}

	private static Volt getVolt(SocketInterface s, int i){
		switch(i){
			case 3: return s.get3Volts();
			case 12: return s.get12Volts();
			case 120: return s.get120Volts();
			default: return s.get120Volts();
		}
	}

}
