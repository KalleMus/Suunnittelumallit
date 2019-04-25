package model;

import javafx.scene.image.Image;
import view.MainView;

public class RealImage implements  Image_IF {
	private final String filename;
	private Image img;
	private MainView mainView;
	private final String path = "/images/";

	/**
	 * Constructor
	 * @param filename
	 */
	public RealImage(String filename, MainView mainView) {
		this.filename = filename;
		this.mainView = mainView;
		loadImageFromDisk();
	}

	/**
	 * Loads the image from the disk
	 */
	private void loadImageFromDisk() {
		System.out.println("Loading   " + filename);
		img = new Image(path + filename);
	}

	/**
	 * Displays the image
	 */
	public void displayImage() {
		System.out.println("Displaying " + filename);
		mainView.getImageView().setImage(img);
	}

	@Override
	public void showData() {
		System.out.println(filename);
	}

	@Override
	public boolean isImageLoaded() {
		return true;
	}

	@Override
	public String getFileName() {
		return null;
	}
}
