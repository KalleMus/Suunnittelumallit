package pokemon;

import javafx.scene.image.Image;
import visitor.Visitor_IF;

public interface PokemonState_IF {

	void attack();
	void defend();
	void move();
	void evolve(Pokemon pokemon);
	void reset(Pokemon pokemon);
	void updateEventText(String text);
	void updatePokeImage();
	Image getImage();
	int getLevel();
	void setLevel(int level);
	String getName();
	void increaseLevel(Visitor_IF evolveCheckerVisitor);

}
