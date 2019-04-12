package builder;

public class Hesburger implements BurgerBuilder_IF {

	private StringBuilder kerroshampurilainen;

	public Hesburger() {
		kerroshampurilainen = new StringBuilder();
	}

	@Override
	public void buildBread() {
		kerroshampurilainen.append("Soft bread\n");
	}

	@Override
	public void buildCheese() {
		kerroshampurilainen.append("Cheddar cheese\n");
	}

	@Override
	public void buildKetchup() {
		kerroshampurilainen.append("Felix ketchup\n");
	}

	@Override
	public void MeatPatty() {
		kerroshampurilainen.append("Tasty meat\n");
	}

	@Override
	public Object getBurger() {
		return kerroshampurilainen;
	}
}
