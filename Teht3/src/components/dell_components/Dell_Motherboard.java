package components.dell_components;

import components.Component;
import java.util.ArrayList;

public class Dell_Motherboard implements Component {

	private String brand = "Dell";
	private double price = 100;
	private ArrayList<Component> childComponents = new ArrayList<>();

	@Override
	public double getPrice() {
		double pricesOfChildComponents = 0;
		for (Component component : childComponents) {
			pricesOfChildComponents += component.getPrice();
		}
		return pricesOfChildComponents + price;
	}

	@Override
	public void addComponent(Component component) {
		childComponents.add(component);
	}

	@Override
	public void removeComponent(Component component) {
		childComponents.remove(component);
	}
}
