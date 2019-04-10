package Main;

/**
 * CEO will accept all raise requests.
 */
public class CEO extends RaiseHandler {

	private String name;
	private final String TITLE = "CEO";

	public CEO(String name) {
		this.name = name;
	}

	@Override
	public void handleRaiseRequest(RaiseRequest request) {
		super.printRaiseAccepted(TITLE, name, request);
	}

	@Override
	public void setNext(RaiseHandler next) {
		super.setNext(next);
	}
}
