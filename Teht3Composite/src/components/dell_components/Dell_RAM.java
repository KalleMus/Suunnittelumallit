package components.dell_components;

import components.Component;

public class Dell_RAM implements Component {

	private String brand = "Dell";
	private double price = 80;

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
