package builder;

import burger_parts.*;

import java.util.ArrayList;
import java.util.List;

public class McDonalds implements BurgerBuilder_IF {

	private List<BurgerParts_IF> bigMac;

	public McDonalds() {
		bigMac = new ArrayList<>();
	}

	@Override
	public void buildBread() {
		bigMac.add(new Bread("Dry bread"));
	}

	@Override
	public void buildCheese() {
		bigMac.add(new Cheese("Cheap cheese"));
	}

	@Override
	public void buildKetchup() {
		bigMac.add(new Ketchup("Bland ketchup"));
	}

	@Override
	public void MeatPatty() {
		bigMac.add(new MeatPatty("Frozen meat"));
	}

	@Override
	public Object getBurger() {
		return bigMac;
	}
}
