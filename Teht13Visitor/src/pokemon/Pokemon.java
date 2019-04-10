package pokemon;

import view.MainView;
import visitor.EvolveCheckerVisitor;
import visitor.Visitor_IF;

public class Pokemon {

	private PokemonState_IF currentForm;
	private Visitor_IF evolveCheckerVisitor;

	public Pokemon(MainView mainView) {
		this.evolveCheckerVisitor = new EvolveCheckerVisitor(this);
		currentForm = Charmander.getInstance(mainView);
	}

	public void setCurrentForm(PokemonState_IF newForm) {
		currentForm = newForm;
	}

	public void attack() {
		currentForm.attack();
	}

	public void defend() {
		currentForm.defend();
	}

	public void move() {
		currentForm.move();
	}

	public void increaseLevel() {
		currentForm.increaseLevel(evolveCheckerVisitor);
	}

	public void reset() {
		currentForm.reset(this);
	}

	public PokemonState_IF getCurrentForm() {
		return currentForm;
	}
}
