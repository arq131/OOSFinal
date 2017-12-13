package model;

import java.util.Observable;
import java.util.Observer;

import states.DoorStates;

public class Doors extends Observable implements Observer {

	private volatile DoorStates state;

	public Doors() {
		state = new DoorStates();
	}

	@Override
	public void update(Observable o, Object arg) {
		state.switchDoors();
		if (state.getCurrentState() == false) {
			this.setChanged();
			this.notifyObservers();
		}

	}

	public void closeDoor() {
		state.close();
	}

	public void openDoor() {
		state.open();
	}

	public boolean isOpen() {
		if (state.getCurrentState())
			return true;
		return false;
	}

	public void printCurrentState() {
		Logger.doorCurrentState(state.getCurrentState());
	}
	
	public boolean hasOpened() {
		return state.hasOpened();
	}
	
	public void reset() {
		state.resetOpen();
	}

}
