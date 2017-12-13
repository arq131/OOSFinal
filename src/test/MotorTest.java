package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Elevator;
import model.Motor;
//import motor.Motor;
import time.MotorTimer;

public class MotorTest {
	private static MotorTimer timer;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		timer = new MotorTimer();
		new Thread(timer).start();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		timer.cancelTimer();
	}

	/*test fails if motor does not stop within 2.1 seconds
	@Test(timeout=2100)
	public void testMotor() {
		//create a motor and add to the timer as an observer
		
		Motor motor = new Motor();
		timer.addObserver(motor);
		
		motor.turnOn();
		while(motor.getCurrentState()) {
		}
		
		//if test makes it here before 2.1 seconds then test passes
		assertTrue(true);
	}*/
	
	@Test
	public void testElevator() {
		Elevator elevator = new Elevator();
		elevator.goUp();
	}

}
