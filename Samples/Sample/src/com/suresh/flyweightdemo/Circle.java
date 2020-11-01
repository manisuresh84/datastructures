package com.suresh.flyweightdemo;

public class Circle implements Shape {
	private int x;
	private int y;
	private String color;

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(this + " :Circle Object X [" + getX() + "] Y [" + getY() + "] Color [" + getColor() +"]");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
