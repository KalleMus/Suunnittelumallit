package burger_parts;

public class Cheese implements BurgerParts_IF {

	private String description;

	public Cheese(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}
