import java.util.Random;

public class Data {

	private int data;

	public Data() {
		this.data = new Random().nextInt(100);
	}

	public Data(int data) {
		this.data = data;
	}

	public String toString() {
		return data + "";
	}
}
