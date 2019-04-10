package model;

/**
 * An instance of this class is created by the DigitalClockObservable.
 * This class increments the time of the DigitalClockObservable by one every second.
 */
public class TimerThread extends Thread {

	private DigitalClockObservable digitalClock;

	/**
	 * Create connection to the DigitalClockObservable
	 * @param digitalClock
	 */
	public TimerThread(DigitalClockObservable digitalClock) {
		this.digitalClock = digitalClock;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				digitalClock.incrementTime();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
