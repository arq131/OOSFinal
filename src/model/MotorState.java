package model;

import time.MyTimer;

public class MotorState {
	private static final boolean ON = true;
	private static final boolean OFF = false;
	private MyTimer timer;
	private Logger logger;
	
	protected boolean state = false;
	
	public MotorState() {
		this.timer = new MyTimer();
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
	 * Turns the motor on
	 */
	public void stateOn() {
		if (state != ON) {
			this.state = ON;
			logger.motorOn();
			timer.run();
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

}
