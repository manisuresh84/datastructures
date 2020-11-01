package com.suresh.csingletonpattern;

/*Singleton pattern is one of the simplest design patterns in Java. 
This type of design pattern comes under creational pattern as this pattern provides one of the best way to create an object. 
This pattern involves a single class which is responsible to creates own object while making sure that only single object get created. 
This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.*/

public class SingletonPatternDemo {

	public static void main(String[] args) {
		//illegal construct
		//Compile Time Error: The constructor SingleObject() is not visible 
		//SingleObject object1 = new SingleObject();
		
		//Get the only object available 
		SingleObject object = SingleObject.getInstance(); 
		//show the message 
		object.showMessage();

	}

}
