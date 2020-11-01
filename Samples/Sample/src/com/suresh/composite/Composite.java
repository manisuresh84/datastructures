package com.suresh.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape {
	private List<Shape> list = new ArrayList<Shape>();

	@Override
	public void draw(String fillColor) {
		for (Shape s : list) {
			s.draw(fillColor);
		}
	}

	public void add(Shape s) {
		list.add(s);
	}

	public void remove(Shape s) {
		list.remove(s);
	}

	public void clearAll() {
		this.list.clear();
		System.out.println("Cleared all the Shapes in list");
	}
}
