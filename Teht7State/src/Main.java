import javafx.application.Application;
import javafx.stage.Stage;
import view.MainView;

/**
 * Creates mainView.
 */
public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		MainView mainView = new MainView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
