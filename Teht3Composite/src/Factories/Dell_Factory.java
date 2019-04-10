package Factories;

import components.Component;
import components.dell_components.*;

public class Dell_Factory implements PcFactory {
	@Override
	public Component createCase() {
		return new Dell_Case();
	}

	@Override
	public Component createSSD() {
		return new Dell_SSD();
	}

	@Override
	public Component createPowerSupply() {
		return new Dell_PowerSupply();
	}

	@Override
	public Component createMotherboard() {
		return new Dell_Motherboard();
	}

	@Override
	public Component createGraphicsCard() {
		return new Dell_GraphicsCard();
	}

	@Override
	public Component createRAM() {
		return new Dell_RAM();
	}
}
