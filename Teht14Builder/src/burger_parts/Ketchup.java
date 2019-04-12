package burger_parts;

public class Ketchup implements BurgerParts_IF {

	private String description;

	public Ketchup(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}
