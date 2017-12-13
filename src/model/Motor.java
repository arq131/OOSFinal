package model;

import java.util.Observable;
import java.util.Observer;

import states.MotorStates;

public class Motor extends Observable implements Observer  {
	
	private MotorStates state;
	
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
		Logger.motorCurrentState(state.getState());
		return state.getState();
	}
	
	public void turnOn() {
		state.stateOn();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void turnOff() {
		state.stateOff();
		this.setChanged();
		this.notifyObservers();
	}
	

}
