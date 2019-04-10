package factorymethod;

public class Pizza implements Ruoka {

	private String name = "pizza";

	@Override
	public String toString() {
		return this.name;
	}
}
