package com.suresh.composite;

public class CompositeTestPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape t = new Triangle();
		Shape c = new Circle();
		Shape t1 = new Triangle();
		Composite comp = new Composite();
		comp.add(t);
		comp.add(t1);
		comp.add(c);

		System.out.println("Composite List Draw :");
		comp.draw("RED");

		comp.clearAll();

		comp.add(t1);
		comp.add(t1);
		comp.remove(t1);
		comp.add(c);

		System.out.println("Composite List Draw :");
		comp.draw("GREEN");
	}
}
