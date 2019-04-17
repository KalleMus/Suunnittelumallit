public class SportsCar implements Car_IF {
	@Override
	public void startCar() {
		System.out.println("Car engine started.");
	}

	@Override
	public void drive() {
		System.out.println("Car is driving.");
	}

	@Override
	public void turnSignal() {
		System.out.println("Blinking turn signal.");
	}

	@Override
	public void stopCar() {
		System.out.println("Car has stopped.");
	}
}
