package model;

import java.util.Observable;

/**
 * This is the observable class that notifies the observer when changes are made into the time values.
 */
public class DigitalClockObservable extends Observable {

	private int seconds = 0, minutes = 0, hours = 0;
	private String seconds_str = "", minutes_str = "", hours_str = "";
	private String displayTime = "";

	/**
	 * Constructor creates an instance of the TimerThead and starts it.
	 */
	public DigitalClockObservable() {
		TimerThread clockTimer = new TimerThread(this);
		clockTimer.start();
	}

	/**
	 * This method is called by an instance of the TimerThread class every one second.
	 * It increments the correct depending on what the current time is.
	 * After that it calls the observer.
	 */
	public void incrementTime() {
		handleMinutes();
		handleHours();
		handleStringConversion();
		setChanged();
		notifyObservers(this);
	}

	/**
	 * This is the method that is called by the observer, when it gets updated.
	 * @return current displayTime.
	 */
	public String getDisplayTime() {
		return displayTime;
	}

	private void handleStringConversion() {
		if (seconds < 10) {
			seconds_str = "0" + seconds;
		}
		else {
			seconds_str = seconds + "";
		}

		if (minutes < 10) {
			minutes_str = "0" + minutes;
		}
		else {
			minutes_str = minutes + "";
		}

		if (hours < 10) {
			hours_str = "0" + hours;
		}
		else {
			hours_str = hours + "";
		}

		displayTime = hours_str + " : " + minutes_str + " : " + seconds_str;
	}

	private void handleHours() {
		if (minutes == 59) {
			minutes = 0;
			hours++;
		}
	}

	private void handleMinutes() {
		if (seconds == 59) {
			seconds = 0;
			minutes++;
		}
		else {
			seconds++;
		}
	}
}
