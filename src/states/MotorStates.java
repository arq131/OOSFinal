package states;

import model.Logger;

public class MotorStates {
	private static final boolean ON = true;
	private static final boolean OFF = false;
	private Logger logger;
	
	protected volatile boolean state = false;
	
	public MotorStates() {
		this.logger = new Logger();
		
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
			logger.motorOff();
		} else {
			this.state = ON;
			logger.motorOn();
		}
	}
	
	/**
	 * Turns the motor on
	 */
	public void stateOn() {
		if (state != ON) {
			this.state = ON;
			logger.motorOn();
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
			logger.motorOff();
		} else {
			System.out.println("Motor state is already off.");
		}
	}

}
