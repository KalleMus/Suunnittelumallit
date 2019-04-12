package burger_parts;

public class MeatPatty implements BurgerParts_IF {

	private String description;

	public MeatPatty(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}
