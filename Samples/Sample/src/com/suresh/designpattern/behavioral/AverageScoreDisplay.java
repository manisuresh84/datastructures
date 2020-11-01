package com.suresh.designpattern.behavioral;

public class AverageScoreDisplay implements Observer {

	private float runRate;
    private int predictedScore;
    
	public AverageScoreDisplay() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(int runs, int wickets, float overs) {
		// TODO Auto-generated method stub
		
		this.runRate =(float)runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();

	}

	public void display()
    {
        System.out.println("\nAverage Score Display: \n"
                           + "Run Rate: " + runRate +
                           "\nPredictedScore: " +
                           predictedScore);
    }
}
