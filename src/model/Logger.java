package model;

public class Logger {
	
	private static final String MOTOR_ON = "Motor is on.";
	private static final String MOTOR_OFF = "Motor is off.";
	private static final String DOOR_CLOSED = "Elevator doors are closed.";
	private static final String DOOR_OPEN = "Elevator doors are open.";

	
	public Logger() {
		
	}
	
	public void motorOn() {
		System.out.println(MOTOR_ON);
	}
	
	public void motorOff() {
		System.out.println(MOTOR_OFF);
	}
	
	public void doorClosed() {
		System.out.println(DOOR_CLOSED);
	}
	
	public void doorOpen() {
		System.out.println(DOOR_OPEN);
	}
	
	public void report(String message) {
		System.out.println(message);
	}
}
