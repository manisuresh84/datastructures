package com.suresh.decorator;

public class ChocolateDecorator extends IcecreamDecorator {

	public ChocolateDecorator(Icecream specialVanillaIceCream) {
		super(specialVanillaIceCream);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeIceCream() {
		// TODO Auto-generated method stub
		return super.makeIceCream() + addChocolate();
	}

	private String addChocolate(){
		return " + with Chocolate";
	}
}
