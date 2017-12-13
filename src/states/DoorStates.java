package states;

import model.Logger;

public class DoorStates {
	
	private static final boolean CLOSED = false;
	private static final boolean OPEN = true;

	
	protected volatile boolean currentState;
	
	public DoorStates() {
		currentState = false;
	}
	
	public boolean getCurrentState() {
		return currentState;
	}
	
	public void switchDoors() {
		if (currentState == OPEN) {
			currentState = CLOSED;
			Logger.doorClosed();
		} else {
			currentState = OPEN;
			Logger.doorOpen();
		}
	}
	
	
	

}
