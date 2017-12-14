package model;

import states.ElevatorStates;

public class Logger {
	
	private static final String MOTOR_ON = "Motor is on.";
	private static final String MOTOR_OFF = "Motor is off.";
	private static final String DOOR_CLOSED = "Elevator doors are closed.";
	private static final String DOOR_OPEN = "Elevator doors are open.";
	private static final String ELEVATOR_IDLE = "Elevator is idle";
	private static final String ELEVATOR_UP = "Elevator is going up";
	private static final String ELEVATOR_DOWN = "Elevator is going down";
	private static final String ELEVATOR_FLOOR = "The elevator arrives at floor ";

	
	public Logger() {
		
	}
	
	public static void motorCurrentState(boolean state) {
		if (state)
			motorOn();
		else
			motorOff();
	}
	
	public static void motorOn() {
		System.out.println(MOTOR_ON);
	}
	
	public static void motorOff() {
		System.out.println(MOTOR_OFF);
	}
	
	public static void doorCurrentState(boolean state) {
		if (state)
			doorOpen();
		else
			doorClosed();
	}
	
	public static void doorClosed() {
		System.out.println(DOOR_CLOSED);
	}
	
	public static void doorOpen() {
		System.out.println(DOOR_OPEN);
	}
	
	public static void elevatorCurrentState(int state) {
		if (state == ElevatorStates.IDLE) {
			elevatorIdle();
		} else if (state == ElevatorStates.UP) {
			elevatorUp();
		} else if (state == ElevatorStates.DOWN) {
			elevatorDown();
		}
	}
	
	public static void elevatorFloor(int floor) {
		System.out.println(ELEVATOR_FLOOR + floor);
	}
	
	public static void elevatorIdle() {
		System.out.println(ELEVATOR_IDLE);
	}
	
	public static void elevatorUp() {
		System.out.println(ELEVATOR_UP);
	}
	
	public static void elevatorDown() {
		System.out.println(ELEVATOR_DOWN);
	}
	
	
}
