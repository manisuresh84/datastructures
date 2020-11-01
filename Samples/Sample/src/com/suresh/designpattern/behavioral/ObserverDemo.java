package com.suresh.designpattern.behavioral;

public class ObserverDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AverageScoreDisplay averageScore = new AverageScoreDisplay();
		CurrentScoreDisplay currentScore = new CurrentScoreDisplay();
		
		CricketData cricketData = new CricketData();
		
		cricketData.registerObserver(averageScore);
		cricketData.registerObserver(currentScore);

		cricketData.dataChanged();
		
		cricketData.unregisterObserver(averageScore);
		cricketData.dataChanged();
	}

}
