package main;

import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private final int playerCount = 2;

	@Override
	public void start(Stage stage) throws Exception {
		MainView mw = new MainView(this);
		mw.getMainStage().show();
		GameThread gt = new GameThread(mw, mw.getController(), playerCount);
		gt.start();
	}
}
