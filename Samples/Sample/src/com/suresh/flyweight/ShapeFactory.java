package com.suresh.flyweight;

import java.util.HashMap;

public class ShapeFactory {
	private static final HashMap<ShapeType, Shape> shapes = new HashMap<ShapeType, Shape>();
	
	public static Shape getShape(ShapeType type){
		System.out.println("Size of Hash Code [" + shapes.hashCode() + "] Hash Size [" + shapes.size() + "]");
		
		Shape  shapeImpl = shapes.get(type);
		
		if(shapeImpl == null){
			if(type.equals(ShapeType.OVAL_FILL)){
				shapeImpl = new Oval(true);
			} else if(type.equals(ShapeType.OVAL_NOFILL)){
				shapeImpl = new Oval(false);
			} else if(type.equals(ShapeType.LINE)){
				shapeImpl = new Line();
			}
			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}
	
	public static enum ShapeType{
		OVAL_FILL, OVAL_NOFILL, LINE;
	}
}
