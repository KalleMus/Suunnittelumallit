package decorator;

import data.Data_IF;

import java.util.Random;

/**
 * BasicEncoder encoder encodes string of data in such a way the where resulting string is gibberish
 * where every other char is the correct one.
 */
public class BasicEncoder extends Encoder {

	public BasicEncoder(Data_IF data) {
		super(data);
	}

	@Override
	public String getData() {
		return setBasicEncoding(super.getData());
	}

	private String setBasicEncoding(String data) {
		int encodedLength = data.length() * 2;
		char[] dataArr = new char[encodedLength];
		for (int i = 0, j = 0; j < encodedLength; i++, j+=2) {
			dataArr[j] = data.charAt(i);
			dataArr[j + 1] = randomChar();
		}
		return new String(dataArr);
	}

	private char randomChar() {
		Random random = new Random();
		char[] charArr = {'a', 'b', 'c', 'd', 'e', 'g', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
		'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z'};
		int randomIndex = random.nextInt(charArr.length);
		return charArr[randomIndex];
	}
}
