package factories;

import clothes.*;

public class AdidasFactory implements ClothingFactory_IF {
	@Override
	public Cap_IF createCap() {
		return new Cap_Adidas();
	}

	@Override
	public Tshirt_IF createTshirt() {
		return new Tshirt_Adidas();
	}

	@Override
	public Jeans_IF createJeans() {
		return new Jeans_Adidas();
	}

	@Override
	public Shoes_IF createShoes() {
		return new Shoes_Adidas();
	}
}
