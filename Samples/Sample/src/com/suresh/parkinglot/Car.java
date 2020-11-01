package com.suresh.parkinglot;

public class Car extends Vehicle {

	public Car() {
		// TODO Auto-generated constructor stub
		spotsNeeded = 1;
		size = VehicleSize.Compact;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}

}
