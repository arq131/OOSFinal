package states;

import model.Logger;

public class ElevatorStates {
	public static final int UP = 0;
	public static final int DOWN = 1;
	public static final int IDLE = 2;
	
	private volatile int currentState;
	private volatile int currentFloor;
	
	
	public ElevatorStates() {
		this.currentState = IDLE;
		this.currentFloor = 1;
	}
	
	public void idle() {
		currentState = IDLE;
	}
	
	public void up() {
		currentState = UP;
	}
	
	public void down() {
		currentState = DOWN;
	}
	
	public boolean goUpOneFloor() {
		currentState = UP;
		if (currentFloor == 5) {
			System.out.println("Already at highest floor: 5");
			return false;
		}
		this.currentFloor++;
		Logger.elevatorCurrentState(currentState);
		return true;
	}
	
	public boolean goDownOneFloor() {
		currentState = DOWN;
		if (currentFloor == 1) {
			System.out.println("Already at lowest floor: 1");
			return false;
		}
		
		this.currentFloor--;
		Logger.elevatorCurrentState(currentState);
		return true;
	}

	
	public int getCurrentState() {
		return this.currentState;
	}
	
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	
	public boolean isIdle() {
		if (currentState == IDLE)
			return true;
		return false;
	}
	
	public void setState(int state) {
		this.currentState = state;
	}

}
