package model;

import java.util.Observable;
import java.util.Observer;

import states.MotorStates;

public class Motor extends Observable implements Observer {

	private volatile MotorStates state;

	public Motor() {
		state = new MotorStates();
	}

	@Override
	public void update(Observable o, Object arg) {
		state.switchState();
		this.setChanged();
		this.notifyObservers();

	}

	public boolean getCurrentState() {
		return state.getState();
	}

	public void printCurrentState() {
		Logger.motorCurrentState(state.getState());
	}

	public void turnOn() {
		state.stateOn();
	}

	public void turnOff() {
		state.stateOff();
	}
	
	public void reset() {
		state.setState(false);
	}

}
