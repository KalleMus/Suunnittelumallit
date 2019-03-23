package factories;

import clothes.Cap_IF;
import clothes.Jeans_IF;
import clothes.Shoes_IF;
import clothes.Tshirt_IF;

public interface ClothingFactory_IF {
	public Cap_IF createCap();
	public Tshirt_IF createTshirt();
	public Jeans_IF createJeans();
	public Shoes_IF createShoes();
}
