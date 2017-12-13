package states;

import model.Logger;

public class DoorStates {
	
	private static final boolean CLOSED = false;
	private static final boolean OPEN = true;
	
	
	protected volatile boolean hasOpened;
	protected volatile boolean currentState;
	
	public DoorStates() {
		currentState = false;
		hasOpened = false;
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
			hasOpened = true;
			Logger.doorOpen();
		}
	}
	
	public void close() {
		currentState = CLOSED;
	}
	
	public void open() {
		currentState = OPEN;
		hasOpened = true;
	}
	
	public boolean hasOpened() {
		if (hasOpened) {
			return true;
		} else {
			return false;
		}
	}
	
	public void resetOpen() {
		hasOpened = false;
	}
	
	
	

}
