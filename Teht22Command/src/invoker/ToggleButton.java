package invoker;

import command.Command;
import javafx.scene.control.Button;

public class ToggleButton extends Button {

	private Command lightsOnCommand, lightsOffCommand;
	private ButtonState state = ButtonState.OFF;

	public ToggleButton(Command lightsOnCommand, Command lightsOffCommand) {
		super();
		this.lightsOnCommand = lightsOnCommand;
		this.lightsOffCommand = lightsOffCommand;
	}

	public void press() {
		switch (state) {
			case ON:
				lightsOffCommand.execute();
				state = ButtonState.OFF;
				break;
			case OFF:
				lightsOnCommand.execute();
				state = ButtonState.ON;
				break;
		}
	}
}
