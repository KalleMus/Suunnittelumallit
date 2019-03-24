package components.dell_components;

import components.Component;

public class Dell_PowerSupply implements Component {

	private String brand = "Dell";
	private double price = 70;

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
