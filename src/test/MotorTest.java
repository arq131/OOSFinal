package test;

import org.junit.Test;

import model.Elevator;

public class MotorTest {
	
	@Test
	public void testElevator() {
		Elevator elevator = new Elevator();
		elevator.goUp();
		elevator.goDown();
	}

}
