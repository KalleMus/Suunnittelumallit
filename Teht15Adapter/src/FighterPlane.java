public class FighterPlane implements Airplane_IF {
	@Override
	public void turnOnEngine() {
		System.out.println("Jet engine turned on.");
	}

	@Override
	public void takeOff() {
		System.out.println("The plane has took off.");
	}

	@Override
	public void deployLandingGear() {
		System.out.println("Landing gear deployed.");
	}

	@Override
	public void land() {
		System.out.println("The plane has landed.");
	}
}
