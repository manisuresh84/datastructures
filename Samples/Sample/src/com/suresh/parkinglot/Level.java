package com.suresh.parkinglot;

public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0;

	private static final int SPOTS_PER_ROW = 10;

	public Level(int floor, int numberSpots) {
		// TODO Auto-generated constructor stub
	}

	public int getAvailableSpots() {
		return availableSpots;
	}

	public boolean parkVehicle(Vehicle vehicle) {
		return false;

	}

	private boolean parkStartingAtSpot(int num, Vehicle v) {
		return false;

	}

	private int findAvailableSpots(Vehicle vehicle) {
		return availableSpots;

	}

	public void spotFreed() {
		availableSpots++;
	}
}
