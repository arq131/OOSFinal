package model;

public class Logger {
	
	private static final String MOTOR_ON = "The Motor has been turned on.";
	private static final String MOTOR_OFF = "The Motor has been turned off.";

	
	public Logger() {
		
	}
	
	public void motorOn() {
		System.out.println(MOTOR_ON);
	}
	
	public void motorOff() {
		System.out.println(MOTOR_OFF);
	}
	
	public void report(String message) {
		System.out.println(message);
	}
}
