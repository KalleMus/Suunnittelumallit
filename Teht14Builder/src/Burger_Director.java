import builder.BurgerBuilder_IF;

public class Burger_Director {

	private BurgerBuilder_IF burgerBuilder;

	public void setBurgerBuilder(BurgerBuilder_IF burgerBuilder) {
		this.burgerBuilder = burgerBuilder;
	}

	public Object getBurger() {
		return burgerBuilder.getBurger();
	}

	public void constructBurger() {
		burgerBuilder.buildBread();
		burgerBuilder.MeatPatty();
		burgerBuilder.buildCheese();
		burgerBuilder.buildKetchup();
	}
}
