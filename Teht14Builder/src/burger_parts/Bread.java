package burger_parts;

public class Bread implements BurgerParts_IF {

	private String description;

	public Bread(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}
