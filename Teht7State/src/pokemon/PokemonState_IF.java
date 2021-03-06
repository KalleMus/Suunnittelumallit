package pokemon;

import javafx.scene.image.Image;

public interface PokemonState_IF {

	void attack();
	void defend();
	void move();
	void levelUp(Pokemon pokemon);
	void reset(Pokemon pokemon);
	void updateEventText(String text);
	void updatePokeImage();
	Image getImage();

}
