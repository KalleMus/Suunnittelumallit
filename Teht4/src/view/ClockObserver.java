package view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import model.DigitalClockObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * This is the observer class that gets the time value of the observable class when this is updated.
 */
public class ClockObserver implements Observer {

	private Label timeField;
	private DigitalClockObservable clock;

	/**
	 * Constructor creates connection to the clock (observable) component
	 * and creates the timeField label GUI component.
	 * @param clock instance of the observable class.
	 */
	public ClockObserver(DigitalClockObservable clock) {
		this.clock = clock;
		timeField = new Label("00 : 00 : 00");
		timeField.setId("timeField");
	}

	/**
	 * Get the timeLabel GUI component. Called by the MainView.
	 * @return
	 */
	public Label getTimeLabel() {
		return timeField;
	}

	/**
	 * Called by the DigitalClockObservable class.
	 * @param obs instance of an observable.
	 * @param arg optional argument passed by the observable.
	 */
	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof DigitalClockObservable) {
			String displayTime = clock.getDisplayTime();
			Platform.runLater(() -> timeField.setText(displayTime));
		}
	}
}
