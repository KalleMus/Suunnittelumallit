package command;

import receiver.MyLight;

public class LightsOffCommand implements Command {

	private MyLight light;

	public LightsOffCommand(MyLight light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
	}
}
