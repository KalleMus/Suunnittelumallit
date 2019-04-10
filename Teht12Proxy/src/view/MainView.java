package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Image_IF;
import java.util.List;

public class MainView {

	private Button nextButton, prevButton, loadImageButton;
	private Label imageLabel;
	private BorderPane borderPane;
	private Scene mainScene;
	private Stage primaryStage;
	private ImageView imageView;
	private HBox mainHBox;
	private VBox imageVBox, folderContentVBox;

	private List<Image_IF> imageFolder;

	private int currentIndex = 0;

	public void start() {
		createGUI();
		imageFolder.get(currentIndex).showData();
	}

	private void createGUI() {
		imageView = new ImageView();
		imageView.setFitWidth(256);
		imageView.setFitHeight(256);
		imageLabel = new Label("");
		imageLabel.setId("imageLabel");
		loadImageButton = new Button("Load image");
		loadImageButton.setId("loadImageButton");
		loadImageButton.setOnMouseClicked(e -> {
			imageFolder.get(currentIndex).displayImage();
			updateFolderVBox();
		});

		nextButton = new Button("Next");
		nextButton.setId("nextButton");
		nextButton.setOnMouseClicked(e -> {
			if (currentIndex < imageFolder.size() - 1) {
				currentIndex++;
				showImage();
			}
		});

		prevButton = new Button("Previous");
		prevButton.setId("prevButton");
		prevButton.setOnMouseClicked(e -> {
			if (currentIndex > 0) {
				currentIndex--;
				showImage();
			}
		});

		imageVBox = new VBox(imageView, imageLabel, loadImageButton);
		imageVBox.setId("imageVBox");
		mainHBox = new HBox(prevButton, imageVBox, nextButton);
		mainHBox.setId("mainHBox");

		folderContentVBox = new VBox();
		folderContentVBox.setId("folderContentVBox");
		updateFolderVBox();

		borderPane = new BorderPane();
		borderPane.setId("borderPane");
		borderPane.setCenter(mainHBox);
		borderPane.setLeft(folderContentVBox);

		mainScene = new Scene(borderPane, 800, 600);
		mainScene.getStylesheets().add("style.css");
		primaryStage = new Stage();
		primaryStage.setScene(mainScene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> System.exit(0));
	}

	private void updateFolderVBox() {
		folderContentVBox.getChildren().clear();
		Label folderLabel = new Label("Image folder");
		folderLabel.setId("folderLabel");
		folderContentVBox.getChildren().add(folderLabel);
		for (int i = 0; i < imageFolder.size(); i++) {
			Label label = new Label(imageFolder.get(i).getFileName());
			if (imageFolder.get(i).isImageLoaded()) {
				label.setTextFill(Color.GREEN);
				label.setStyle("-fx-font-weight: bold");
			}
			folderContentVBox.getChildren().add(label);
		}
	}

	private void showImage() {
		imageFolder.get(currentIndex).showData();
		if (imageFolder.get(currentIndex).isImageLoaded()) {
			imageFolder.get(currentIndex).displayImage();
		}
		else {
			imageView.setImage(null);
		}
		updateFolderVBox();
	}

	public void setImageFolder(List<Image_IF> imageFolder) {
		this.imageFolder = imageFolder;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public Label getImageLabel() {
		return imageLabel;
	}
}
