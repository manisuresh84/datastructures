package com.suresh.decorator;

public class DecoratorClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VanillaIcecream vanillaIcecreamObj = new VanillaIcecream();
		String vanillaIcecream = vanillaIcecreamObj.makeIceCream();
		System.out.println(vanillaIcecream);

		String vanillaIcecreamWithNuts = new NuttyDecorator(vanillaIcecreamObj).makeIceCream();
		System.out.println("\n'" + vanillaIcecreamWithNuts + "' is prepared using NuttyDecorator");

		String vanillaIcecreamWithChocalate = new ChocolateDecorator(vanillaIcecreamObj).makeIceCream();
		System.out.println("\n'" + vanillaIcecreamWithChocalate + "' is prepared using ChocolateDecorator");

		String vanillaIcecreamWithChocalateAndNuts = new NuttyDecorator(new ChocolateDecorator(vanillaIcecreamObj))
				.makeIceCream();
		System.out.println("\n'" + vanillaIcecreamWithChocalateAndNuts
				+ "' is prepared using ChocolateDecorator and NuttyDecorator");

	}

}
