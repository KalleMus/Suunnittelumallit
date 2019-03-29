package decorator;

import data.Data_IF;

public abstract class Encoder implements Data_IF {

	protected Data_IF data;

	public Encoder(Data_IF data) {
		this.data = data;
	}

	@Override
	public String getData() {
		return data.getData();
	}
}
