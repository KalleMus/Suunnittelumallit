package factorymethod;

public class Kebab implements Ruoka {

	private String name = "kebab";

	@Override
	public String toString() {
		return this.name;
	}
}
