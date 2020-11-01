package com.suresh.cabstractfactorypattern;

public abstract class AbstractFactory  {
	abstract Shape getShape(String shapeType);
	abstract Color getColor(String colorType);
}
