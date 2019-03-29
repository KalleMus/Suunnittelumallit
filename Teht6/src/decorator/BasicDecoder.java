package decorator;

import data.Data_IF;

public class BasicDecoder extends Decoder {

	public BasicDecoder(Data_IF data) {
		super(data);
	}

	@Override
	public String getData() {
		return decodeData(super.getData());
	}

	/**
	 * Tries to decode the given data.
	 * @param data read from the file.
	 * @return decoded data or an error message.
	 */
	private String decodeData(String data) {
		try {
			int decodedSize = data.length() / 2;
			char[] dataArr = new char[decodedSize];
			for (int i = 0, j = 0; i < data.length(); i+=2, j++) {
				dataArr[j] = data.charAt(i);
			}
			return new String(dataArr);
		} catch (Exception e) {
			return "Unable to decode the file";
		}
	}
}
