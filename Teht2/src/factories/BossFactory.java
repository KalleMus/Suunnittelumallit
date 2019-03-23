package factories;

import clothes.*;

public class BossFactory implements ClothingFactory_IF {
	@Override
	public Cap_IF createCap() {
		return new Cap_Boss();
	}

	@Override
	public Tshirt_IF createTshirt() {
		return new Tshirt_Boss();
	}

	@Override
	public Jeans_IF createJeans() {
		return new Jeans_Boss();
	}

	@Override
	public Shoes_IF createShoes() {
		return new Shoes_Boss();
	}
}
