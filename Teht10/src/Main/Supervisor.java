package Main;

/**
 * Supervisor is allowed to give a raise of 2% otherwise he will send the request to his / her next.
 */
public class Supervisor extends RaiseHandler {

	private String name;
	private final String TITLE = "Supervisor";
	private final double RAISE_PERCENT = 0.02;

	public Supervisor(String name) {
		this.name = name;
	}

	@Override
	public void handleRaiseRequest(RaiseRequest request) {
		if (super.allowRaise(request, RAISE_PERCENT)) {
			super.printRaiseAccepted(TITLE, name, request);
		}
		else {
			super.handleRaiseRequest(request);
		}
	}

	@Override
	public void setNext(RaiseHandler next) {
		super.setNext(next);
	}
}
