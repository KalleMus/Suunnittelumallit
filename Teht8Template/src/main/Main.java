package main;

import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Creates the mainView.
 */
public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		MainView mw = new MainView();
	}
}
