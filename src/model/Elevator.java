package model;

import java.util.Observable;
import java.util.Observer;

import states.ElevatorStates;
import time.DoorTimer;
import time.MotorTimer;

public class Elevator implements Observer {
	private MotorTimer motorTimer;
	private DoorTimer doorTimer;
	private Doors doors;
	private Motor motor;
	private ElevatorStates state;
	
	
	public Elevator() {
		motorTimer = new MotorTimer();
		doorTimer = new DoorTimer();
		doors = new Doors();
		motor = new Motor();
		state = new ElevatorStates();
		
		motor.addObserver(this);
		doorTimer.addObserver(doors);
		motorTimer.addObserver(motor);
	}
	
	public void goUp() {
		printCurrentStates();
		if (state.isIdle()) {
			state.up();
			motorTimer.run();
		}
	}
	
	public void goDown() {
		
	}
	
	public void openDoor() {
		
	}
	
	public void closeDoor() {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (state.getCurrentState() == ElevatorStates.UP) {
			state.goUpOneFloor();
			state.idle();
		} else if (state.getCurrentState() == ElevatorStates.IDLE) {
			Logger.elevatorFloor(state.getCurrentFloor());
			motorTimer.cancelTimer();
		}
		
	}
	
	public void printCurrentStates() {
		motor.getCurrentState();
		doors.getCurrentState();
		Logger.elevatorCurrentState(state.getCurrentState());
		
	}
	
	

}
