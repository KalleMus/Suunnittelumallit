package Main;

/**
 * Raise request "form" with the requester's name, current wage and asked raise.
 */
public class RaiseRequest {

	private double currentWage;
	private double raise;
	private String name;

	public RaiseRequest(String name, double currentWage, double raise) {
		this.name = name;
		this.currentWage = currentWage;
		this.raise = raise;
	}

	public double getRaise() {
		return raise;
	}

	public double getCurrentWage() {
		return currentWage;
	}

	public String getName() {
		return name;
	}
}
