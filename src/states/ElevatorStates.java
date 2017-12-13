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
	
	public void goUpOneFloor() {
		if (currentFloor == 5) {
			System.out.println("Already at highest floor: 5");
			return;
		}
		currentState = UP;
		this.currentFloor++;
		Logger.elevatorCurrentState(currentState);
	}
	
	public void goDownOneFloor() {
		if (currentFloor == 1) {
			System.out.println("Already at lowest floor: 1");
			return;
		}
		currentState = DOWN;
		this.currentFloor--;
		Logger.elevatorCurrentState(currentState);
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

}
