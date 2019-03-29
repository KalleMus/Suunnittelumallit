package decorator;

import data.Data_IF;

import java.util.Random;

/**
 * AdvancedEncoder encoder encodes string of data in such a way the where resulting string is gibberish
 * where every tenth char is the correct one.
 */
public class AdvancedEncoder extends Encoder {

	public AdvancedEncoder(Data_IF data) {
		super(data);
	}

	@Override
	public String getData() {
		return setAdvancedEncoding(super.getData());
	}

	private String setAdvancedEncoding(String data) {
		int encodedLength = data.length() * 10;
		char[] dataArr = new char[encodedLength];
		for (int i = 0, j = 0; j < encodedLength; i++, j+=10) {
			dataArr[j] = data.charAt(i);
			dataArr[j + 1] = randomChar();
			dataArr[j + 2] = randomChar();
			dataArr[j + 3] = randomChar();
			dataArr[j + 4] = randomChar();
			dataArr[j + 5] = randomChar();
			dataArr[j + 6] = randomChar();
			dataArr[j + 7] = randomChar();
			dataArr[j + 8] = randomChar();
			dataArr[j + 9] = randomChar();
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
