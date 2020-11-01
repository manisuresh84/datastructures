package com.suresh.parkinglot;

public class Bus extends Vehicle {

	
	public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}

}
