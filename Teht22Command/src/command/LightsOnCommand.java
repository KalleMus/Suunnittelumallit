package command;

import receiver.MyLight;

public class LightsOnCommand implements Command {

	private MyLight light;

	public LightsOnCommand(MyLight light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOn();
	}
}
