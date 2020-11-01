package com.suresh.parkinglot;

public class ParkingSpot {
	
	private Vehicle vehicle;
	private VehicleSize sportSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	

	public ParkingSpot(Level level, int r, int n, VehicleSize s) {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isAvailable(){
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle vehicle){
		return false;
		
	}

	public boolean park(Vehicle v){
		return false;
		
	}
	
	public int getRow(){
		return row;
	}
	
	public int getSpotNumber(){
		return spotNumber;
	}
	
	public void removeVehicle(){
		
	}
}
