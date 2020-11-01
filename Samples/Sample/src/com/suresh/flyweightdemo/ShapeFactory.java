package com.suresh.flyweightdemo;

import java.util.HashMap;

public class ShapeFactory {
	private static HashMap<String, Shape> shapeMap = new HashMap<String, Shape>();

	public static Shape getShape(String type) {
		Shape s = null;
		if (type.equalsIgnoreCase("circle")) {
			s = (Circle) shapeMap.get("circle");
			if (s == null) {
				s = new Circle();
				shapeMap.put("circle", s);
				System.out.println("Creating Circle object without any color in shape factory :" + s);
			}
		}
		return s;
	}
}
