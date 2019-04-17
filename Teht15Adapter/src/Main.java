public class Main {

	public static void main(String[] args) {

		Airplane_IF hornetF18 = new FighterPlane();
		Car_IF paganiZondaR = new SportsCar();
		Airplane_IF paganiZondaAdapted = new CarToPlaneAdapter(paganiZondaR);

		System.out.println("--- Hornet F18 ---");
		hornetF18.turnOnEngine();
		hornetF18.takeOff();
		hornetF18.deployLandingGear();
		hornetF18.land();
		System.out.println();

		System.out.println("--- Pagani Zonda R ---");
		paganiZondaR.startCar();
		paganiZondaR.drive();
		paganiZondaR.turnSignal();
		paganiZondaR.stopCar();
		System.out.println();

		System.out.println("--- Pagani Zonda Adapted ---");
		paganiZondaAdapted.turnOnEngine();
		paganiZondaAdapted.takeOff();
		paganiZondaAdapted.deployLandingGear();
		paganiZondaAdapted.land();
		System.out.println();
	}
}
