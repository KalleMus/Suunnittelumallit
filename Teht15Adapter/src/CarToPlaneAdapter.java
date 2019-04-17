public class CarToPlaneAdapter implements Airplane_IF {

	private Car_IF car;

	public CarToPlaneAdapter(Car_IF car) {
		this.car = car;
	}

	@Override
	public void turnOnEngine() {
		car.startCar();
	}

	@Override
	public void takeOff() {
		car.drive();
	}

	@Override
	public void deployLandingGear() {
		car.turnSignal();
	}

	@Override
	public void land() {
		car.stopCar();
	}
}
