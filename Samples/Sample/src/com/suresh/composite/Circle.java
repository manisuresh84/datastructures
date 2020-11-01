package com.suresh.composite;

public class Circle implements Shape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Draw method in Circle : " + fillColor);
	}

}
