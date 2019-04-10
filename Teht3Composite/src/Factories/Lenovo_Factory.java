package Factories;

import components.Component;
import components.dell_components.*;
import components.lenovo_components.*;

public class Lenovo_Factory implements PcFactory {
	@Override
	public Component createCase() {
		return new Lenovo_Case();
	}

	@Override
	public Component createSSD() {
		return new Lenovo_SSD();
	}

	@Override
	public Component createPowerSupply() {
		return new Lenovo_PowerSupply();
	}

	@Override
	public Component createMotherboard() {
		return new Lenovo_Motherboard();
	}

	@Override
	public Component createGraphicsCard() {
		return new Lenovo_GraphicsCard();
	}

	@Override
	public Component createRAM() {
		return new Lenovo_RAM();
	}
}
