package view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.DigitalClockObservable;
import java.util.Observable;
import java.util.Observer;

/**
 * This is the observer class that gets the time value of the observable class when this is updated.
 */
public class ClockObserver implements Observer {

	private Label timeLabel;
	private DigitalClockObservable clock;

	/**
	 * Constructor creates connection to the clock (observable) component
	 * and creates the timeLabel label GUI component.
	 * @param clock instance of the observable class.
	 */
	public ClockObserver(DigitalClockObservable clock) {
		this.clock = clock;
		timeLabel = new Label("00 : 00 : 00");
		timeLabel.setId("timeLabel");
	}

	/**
	 * Get the digital clock as a GUI widget. Called by the MainView.
	 * @return HBox containing the current time label.
	 */
	public HBox getDigitalClockWidget() {
		HBox clockBox = new HBox(timeLabel);
		clockBox.setId("clockBox");
		return clockBox;
	}

	/**
	 * Called by the DigitalClockObservable class.
	 * Gets the current time from the observable and updates the observers display time.
	 * @param obs instance of an observable.
	 * @param arg optional argument passed by the observable.
	 */
	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof DigitalClockObservable) {
			String displayTime = clock.getDisplayTime();
			Platform.runLater(() -> timeLabel.setText(displayTime));
		}
	}
}
