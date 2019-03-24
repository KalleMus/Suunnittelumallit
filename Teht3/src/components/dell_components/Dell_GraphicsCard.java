package components.dell_components;

import components.Component;

public class Dell_GraphicsCard implements Component {

	private String brand = "Dell";
	private double price = 230;

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void addComponent(Component component) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeComponent(Component component) {
		throw new UnsupportedOperationException();
	}
}
