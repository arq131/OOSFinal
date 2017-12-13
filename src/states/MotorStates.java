package states;

import model.Logger;

public class MotorStates {
	private static final boolean ON = true;
	private static final boolean OFF = false;
	
	protected volatile boolean state;
	
	public MotorStates() {
		state = OFF;
	}
	
	/**
	 * gets the current state of the motor
	 * @return
	 */
	public boolean getState() {
		return this.state;
	}
	
	/**
	 * Changes the state of the motor.
	 */
	public void switchState() {
		if (state == ON) {
			this.state = OFF;
			Logger.motorOff();
		} else {
			this.state = ON;
			Logger.motorOn();
		}
	}
	
	/**
	 * Turns the motor on
	 */
	public void stateOn() {
		if (state != ON) {
			this.state = ON;
		} else {
			// use logger?
			System.out.println("Motor state is already on.");
		}

	}
	
	/**
	 * Turns the motor off
	 */
	public void stateOff() {
		if (state != OFF) {
			this.state = OFF;
		} else {
			System.out.println("Motor state is already off.");
		}
	}
	
	public boolean isOn() {
		if (state == ON) 
			return true;
		return false;
	}
	
	public boolean isOff() {
		if (state == OFF)
			return true;
		return false;
	}

}
