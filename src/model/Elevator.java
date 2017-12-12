package model;

import time.MyTimer;

public class Elevator {
	private MyTimer timer;
	private Doors doors;
	private Motor motor;
	
	
	public Elevator() {
		timer = new MyTimer();
		doors = new Doors();
		motor = new Motor();
		timer.addObserver(doors);
		timer.addObserver(motor);
	}
	
	

}
