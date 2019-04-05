package Main;

public abstract class RaiseHandler {

	public RaiseHandler next;

	/**
	 * Add next in to the chain of RaiseHandlers.
	 * @param next
	 */
	public void setNext(RaiseHandler next) {
		this.next = next;
	}

	/**
	 * Call handleRaiseRequest on the next.
	 * @param request
	 */
	public void handleRaiseRequest(RaiseRequest request) {
		if (next != null) {
			next.handleRaiseRequest(request);
		}
	}

	/**
	 * Calculation if the raise request should be allowed.
	 * @param request raise request object.
	 * @param percent percent of raise the current handler is allowed to accept.
	 * @return
	 */
	public boolean allowRaise(RaiseRequest request, double percent) {
		double currentWage = request.getCurrentWage();
		double raise = request.getRaise();
		return currentWage + (currentWage * percent) > raise + currentWage;
	}

	/**
	 * When raise has been accepted them print it.
	 * @param title title of the RaiseHandler that accepted the raise.
	 * @param name name of the RaiseHandler that accepted the raise.
	 * @param request RaiseRequest object.
	 */
	public void printRaiseAccepted(String title, String name, RaiseRequest request) {
		System.out.println(title + " " + name + " will approve " + request.getRaise() + "$ raise to " + request.getName() + "'s current salary.");
		System.out.println(request.getName() + "'s new salary is: " + (request.getCurrentWage() + request.getRaise()) + "$ a month.");
	}
}
