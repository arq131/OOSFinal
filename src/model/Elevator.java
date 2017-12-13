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
	private volatile ElevatorStates state;

	public Elevator() {
		motorTimer = new MotorTimer();
		doorTimer = new DoorTimer();
		doors = new Doors();
		motor = new Motor();
		state = new ElevatorStates();

		motor.addObserver(this);
		doors.addObserver(this);
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
		printCurrentStates();
		if (state.isIdle()) {
			state.down();
			motorTimer.run();
			doorTimer.run();
		}
	}

	public void openDoor() {
		doorTimer.run();

	}

	public void closeDoor() {
		doorTimer.cancelTimer();
	}

	@Override
	public void update(Observable o, Object arg) {
		if (state.getCurrentState() == ElevatorStates.UP && !doors.isOpen()) {
			state.goUpOneFloor();
			state.idle();
			return;
		} else if (state.getCurrentState() == ElevatorStates.DOWN && !doors.isOpen()) {
			state.goDownOneFloor();
			state.idle();
			return;
		} else if (state.getCurrentState() == ElevatorStates.IDLE && !doors.isOpen() && !doors.hasOpened()) {
			motorTimer.cancelTimer();
			Logger.elevatorFloor(state.getCurrentFloor());
			
			doorTimer.run();
		}
		motorTimer.cancelTimer();
		doorTimer.cancelTimer();
		doors.reset();
		
	}

	public void printCurrentStates() {
		motor.printCurrentState();
		doors.printCurrentState();
		Logger.elevatorCurrentState(state.getCurrentState());

	}

}
