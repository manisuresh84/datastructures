package com.suresh.flyweightdemo;

public class FlyWeightDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 10; i++){
			Circle circle = (Circle) ShapeFactory.getShape("circle");
			circle.setColor("Red");
			circle.setX(10);
			circle.setY(20);
			circle.draw();
		}
		
		for(int i = 0 ; i < 10; i++){
			Circle circle = (Circle) ShapeFactory.getShape("circle");
			circle.setColor("Green");
			circle.setX(40);
			circle.setY(50);
			circle.draw();
		}
	}

}
