package Factories;

import components.Component;

public interface PcFactory {
	Component createCase();
	Component createSSD();
	Component createPowerSupply();
	Component createMotherboard();
	Component createGraphicsCard();
	Component createRAM();
}
