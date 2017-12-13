package time;

import java.util.Observable;

public class DoorTimer extends Observable implements Runnable {
	//default 1 second per tick
	public static final int MS_PER_TICK = 3000;
	
	private long startTime;
	private boolean canceled;
	
	public DoorTimer() {
		startTime = System.currentTimeMillis();
	}
	
	public void cancelTimer() {
		canceled = true;
	}
	
	@Override
	public void run() {
		canceled = false;

		while(!canceled) {
			long currentTime = System.currentTimeMillis();
		
			//notify observers every tick
			if(currentTime - startTime > MS_PER_TICK) {
			
				this.setChanged();
				this.notifyObservers();
			
				startTime = currentTime;
			}
		}	
	}
}