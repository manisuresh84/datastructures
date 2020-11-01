package com.suresh.parkinglot;

public class MotorCycle extends Vehicle {

	public MotorCycle() {
		// TODO Auto-generated constructor stub
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		// TODO Auto-generated method stub
		return false;
	}

}
