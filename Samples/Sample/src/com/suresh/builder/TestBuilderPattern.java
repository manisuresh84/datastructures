package com.suresh.builder;

public class TestBuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer obj = new Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
		Computer obj1 = new Computer.ComputerBuilder("700 GB", "8 GB").setBluetoothEnabled(true).setGraphicsCardEnabled(true).build();
		System.out.println(obj.toString());
		System.out.println(obj1.toString());
	}

}
