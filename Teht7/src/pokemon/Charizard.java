package pokemon;

import javafx.scene.image.Image;
import view.MainView;

public class Charizard implements PokemonState_IF {

	private String name = "Charizard";
	private static MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charizard.jpg");
	private static Charizard charizard;

	public static PokemonState_IF getInstance(MainView mw) {
		mainView = mw;
		if (charizard == null) {
			charizard = new Charizard();
		}
		return charizard;
	}

	private Charizard() {
	}

	@Override
	public void levelUp(Pokemon pokemon) {
		updateEventText("This pokemon can't level up anymore.");
		System.out.println("This pokemon can't level up anymore.");
	}

	@Override
	public void reset(Pokemon pokemon) {
		updateEventText("");
		pokemon.setCurrentForm(Charmander.getInstance(mainView));
	}

	@Override
	public void attack() {
		updateEventText(name + " uses Flamethrower! It's super effective");
		System.out.println(name + " uses Flamethrower! It's super effective");
	}

	@Override
	public void defend() {
		updateEventText(name + " roars at their foes and their run away.");
		System.out.println(name + " roars at their foes and their run away.");
	}

	@Override
	public void move() {
		updateEventText(name + " flies to a new spot.");
		System.out.println(name + " flies to a new spot.");
	}

	@Override
	public void updateEventText(String text) {
		mainView.updateEventLabel(text);
	}

	@Override
	public void updatePokeImage() {
		mainView.updatePokeImage();
	}

	@Override
	public Image getImage() {
		return pokeImage;
	}
}
