package states;

import model.Logger;

public class DoorStates {
	
	private static final boolean CLOSED = false;
	private static final boolean OPEN = true;
	private Logger logger;
	
	protected volatile boolean currentState;
	
	public DoorStates() {
		currentState = false;
		logger = new Logger();
	}
	
	
	public boolean getCurrentState() {
		return currentState;
	}
	
	public void switchDoors() {
		if (currentState == OPEN) {
			currentState = CLOSED;
			logger.doorClosed();
		} else {
			currentState = OPEN;
			logger.doorOpen();
		}
	}
	
	
	

}
