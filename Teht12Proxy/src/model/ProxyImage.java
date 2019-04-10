package model;

import view.MainView;

// On System B
public class ProxyImage implements Image_IF {
	private final String filename;
	private RealImage image;
	private MainView mainView;

	/**
	 * Constructor
	 * @param filename
	 */
	public ProxyImage(String filename, MainView mainView) {
		this.filename = filename;
		this.mainView = mainView;
	}

	/**
	 * Displays the image
	 */
	public void displayImage() {
		if (image == null) {
			image = new RealImage(filename, mainView);
		}
		image.displayImage();
	}

	@Override
	public void showData() {
		System.out.println(filename);
		mainView.getImageLabel().setText(filename);
	}

	public boolean isImageLoaded() {
		return image != null;
	}


	@Override
	public String getFileName() {
		return filename;
	}
}