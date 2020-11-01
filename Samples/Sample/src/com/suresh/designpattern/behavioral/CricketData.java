package com.suresh.designpattern.behavioral;

import java.util.ArrayList;
import java.util.Iterator;

public class CricketData implements Subject {

	int runs;
	int wickets;
	float overs;
	ArrayList<Observer> observerList;

	public int getRuns() {
		return 10;
	}

	public int getWickets() {
		return 2;
	}

	public float getOvers() {
		return (float) 10.2;
	}

	public CricketData() {
		// TODO Auto-generated constructor stub
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observerList.add(o);

	}

	@Override
	public void unregisterObserver(Observer o) {
		// TODO Auto-generated method stub
		observerList.remove(o);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.update(runs, wickets, overs);
		}
	}
	
	public void dataChanged()
    {
        //get latest data
        runs = getRuns();
        wickets = getWickets();
        overs = getOvers();
 
        notifyObservers();
    }

}
