package com.suresh.template;

public class TemplatePatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseTemplate t = new WoodenHouse();
		t.buildHouse();
		System.out.println();
		System.out.println("******************");
		HouseTemplate t1 = new GlassHouse();
		t1.buildHouse();
	}

}
