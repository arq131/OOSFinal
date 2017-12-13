package model;

import java.util.Observable;
import java.util.Observer;

import states.DoorStates;

public class Doors implements Observer {
	
	private DoorStates state;
	
	public Doors() {
		state = new DoorStates();
	}

	@Override
	public void update(Observable o, Object arg) {
		state.switchDoors();
	}
	
	public boolean getCurrentState() {
		Logger.doorCurrentState(state.getCurrentState());
		return state.getCurrentState();
	}
	

}
