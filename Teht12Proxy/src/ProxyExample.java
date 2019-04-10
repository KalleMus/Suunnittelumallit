import javafx.application.Application;
import javafx.stage.Stage;
import model.Image_IF;
import model.ProxyImage;
import view.MainView;

import java.util.ArrayList;
import java.util.List;

public class ProxyExample extends Application {

	private List<Image_IF> imageFolder = new ArrayList<>();

	@Override
	public void start(Stage stage) throws Exception {
		MainView view = new MainView();

		Image_IF bird = new ProxyImage("bird.jpg", view);
		Image_IF flower = new ProxyImage("flower.jpg", view);
		Image_IF rock = new ProxyImage("rock.jpg", view);
		Image_IF water = new ProxyImage("water.jpg", view);
		Image_IF volcano = new ProxyImage("volcano.jpg", view);

		imageFolder.add(bird);
		imageFolder.add(flower);
		imageFolder.add(rock);
		imageFolder.add(water);
		imageFolder.add(volcano);

		view.setImageFolder(imageFolder);
		view.start();
	}

	/**
	 * Test method
	 */
	public static void main(final String[] args) {
		launch(args);
	}
}
