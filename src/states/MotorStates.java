package states;

import model.Logger;

public class MotorStates {
	private static final boolean ON = true;
	private static final boolean OFF = false;
	
	protected volatile boolean state;
	
	public MotorStates() {
		state = OFF;
	}

	public boolean getState() {
		return this.state;
	}
	
	public void switchState() {
		if (state == ON) {
			this.state = OFF;
			Logger.motorOff();
		} else {
			this.state = ON;
			Logger.motorOn();
		}
	}

	public void stateOn() {
		if (state != ON) {
			this.state = ON;
			Logger.motorOn();
		}
	}
	
	public void stateOff() {
		if (state != OFF) {
			this.state = OFF;
			Logger.motorOff();
		}
	}
	
	public void setState(boolean state) {
		this.state = state;
	}

}
