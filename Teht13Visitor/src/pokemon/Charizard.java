package pokemon;

import javafx.scene.image.Image;
import view.MainView;
import visitor.Visitor_IF;

public class Charizard implements PokemonState_IF {

	private String name = "Charizard";
	private static MainView mainView;
	private Image pokeImage = new Image("/pokemon/images/charizard.jpg");
	private static Charizard charizard;
	private int level;

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
	public void evolve(Pokemon pokemon) {
		updateEventText("This pokemon can't evolve anymore.");
		updatePokeImage();
	}

	@Override
	public void reset(Pokemon pokemon) {
		updateEventText("");
		pokemon.setCurrentForm(Charmander.getInstance(mainView));
		level = 1;
		mainView.updateCurrentLevelLabel(level);
		updatePokeImage();
	}

	@Override
	public void attack() {
		updateEventText(name + " uses Flamethrower! It's super effective");
	}

	@Override
	public void defend() {
		updateEventText(name + " roars at their foes and their run away.");
	}

	@Override
	public void move() {
		updateEventText(name + " flies to a new spot.");
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

	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void increaseLevel(Visitor_IF evolveCheckerVisitor) {
		level++;
		mainView.updateCurrentLevelLabel(level);
		evolveCheckerVisitor.visit(this);
	}
}
