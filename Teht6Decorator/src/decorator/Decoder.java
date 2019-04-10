package decorator;

import data.Data_IF;

public abstract class Decoder implements Data_IF {

	protected Data_IF data;

	public Decoder(Data_IF data) {
		this.data = data;
	}

	@Override
	public String getData() {
		return data.getData();
	}
}
