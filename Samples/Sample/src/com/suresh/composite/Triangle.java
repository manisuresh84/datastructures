package com.suresh.composite;

public class Triangle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Draw method in Triangle : " + fillColor);
	}

}
