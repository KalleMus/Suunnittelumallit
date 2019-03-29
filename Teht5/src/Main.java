import View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		MainView mainView = new MainView();
		mainView.getVisibleStage().show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
