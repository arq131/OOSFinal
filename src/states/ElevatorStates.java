package states;

public class ElevatorStates {
	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int IDLE = 2;
	
	private volatile int currentState;
	
	public ElevatorStates() {
		currentState = IDLE;
	}
}
