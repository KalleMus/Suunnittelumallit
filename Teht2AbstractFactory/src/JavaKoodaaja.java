import clothes.Cap_IF;
import clothes.Jeans_IF;
import clothes.Shoes_IF;
import clothes.Tshirt_IF;

public class JavaKoodaaja {

	private String name;

	// Clothes
	private Cap_IF cap;
	private Tshirt_IF tShirt;
	private Jeans_IF jeans;
	private Shoes_IF shoes;

	public JavaKoodaaja(String name) {
		this.name = name;
	}

	public String greeting() {
		return "Hei! Minun nimeni on " + name + ".";
	}

	public String wearingClothes() {
		return "Minulla on ylläni: \n" +
				cap.toString() + ",\n" +
				tShirt.toString() + ",\n" +
				jeans.toString() + ",\n" +
				shoes.toString() + ".\n";
	}

	public void wearCap(Cap_IF cap) {
		this.cap = cap;
	}

	public void weartShirt(Tshirt_IF tShirt) {
		this.tShirt = tShirt;
	}

	public void wearJeans(Jeans_IF jeans) {
		this.jeans = jeans;
	}

	public void wearShoes(Shoes_IF shoes) {
		this.shoes = shoes;
	}
}
