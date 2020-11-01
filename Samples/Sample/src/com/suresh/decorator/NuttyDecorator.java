package com.suresh.decorator;

public class NuttyDecorator extends IcecreamDecorator {

	public NuttyDecorator(Icecream specialVanillaIceCream) {
		super(specialVanillaIceCream);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String makeIceCream() {
		// TODO Auto-generated method stub
		return super.makeIceCream() + addNutty();
	}
	
	private String addNutty(){
		return " + with Nutty";
	}

}
