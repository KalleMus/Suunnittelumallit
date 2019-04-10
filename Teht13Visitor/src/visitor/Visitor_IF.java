package visitor;

import pokemon.PokemonState_IF;

public interface Visitor_IF {

	void visit(PokemonState_IF currentForm);

}
