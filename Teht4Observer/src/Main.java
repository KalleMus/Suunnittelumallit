import javafx.application.Application;
import javafx.stage.Stage;
import model.DigitalClockObservable;
import view.ClockObserver;
import view.MainView;

public class Main extends Application {

    /**
     * Creates the observable (clockModel), observer (clockGUI), adds observer to observable,
     * then starts the GUI.
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        DigitalClockObservable clock = new DigitalClockObservable();
        ClockObserver clockObserver = new ClockObserver(clock);
        clock.addObserver(clockObserver);
        MainView mainView = new MainView(clockObserver);
        mainView.getCurrentStage().show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
