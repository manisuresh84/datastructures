package com.suresh.bridge;

public class Triangle extends Shape {

	public Triangle(Color c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyColor() {
		// TODO Auto-generated method stub
		System.out.print("Triangle filled with color ");
		color.applyColor();
	}

}
