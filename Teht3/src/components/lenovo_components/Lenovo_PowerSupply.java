package components.lenovo_components;

import components.Component;

public class Lenovo_PowerSupply implements Component {

	private double price = 120;

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
