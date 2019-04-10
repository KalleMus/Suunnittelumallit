package visitor;

import pokemon.Pokemon;
import pokemon.PokemonState_IF;

public class EvolveCheckerVisitor implements Visitor_IF {

	private final int CHARMANDER_LEVEL_UP = 7;
	private final int CHARMELEON_LEVEL_UP = 15;

	private Pokemon pokemon;

	public EvolveCheckerVisitor(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public void visit(PokemonState_IF currentForm) {
		if (currentForm.getLevel() == CHARMANDER_LEVEL_UP || currentForm.getLevel() == CHARMELEON_LEVEL_UP) {
			currentForm.evolve(pokemon);
			pokemon.getCurrentForm().setLevel(currentForm.getLevel());
		}
		else {
			pokemon.getCurrentForm().updateEventText(currentForm.getName() + " levels up!");
		}
	}

}
