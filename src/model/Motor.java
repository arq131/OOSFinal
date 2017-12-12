package model;

import java.util.Observable;
import java.util.Observer;

import states.MotorStates;

public class Motor implements Observer {
	
	private MotorStates state;
	
	public Motor() {
		state = new MotorStates();
	}

	@Override
	public void update(Observable o, Object arg) {
		state.switchState();
		
	}
	
	public boolean getCurrentState() {
		return state.getState();
	}
	
	public void turnOn() {
		state.stateOn();
	}
	
	public void turnOff() {
		state.stateOff();
	}

}
