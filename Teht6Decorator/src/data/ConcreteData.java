package data;


/**
 * Concrete data class is a simple class that contains a string of data.
 */
public class ConcreteData implements Data_IF {

	private String data;

	public ConcreteData(String data) {
		this.data = data;
	}

	@Override
	public String getData() {
		return data;
	}
}
