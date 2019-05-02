import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = -1;
		while (input != 0) {
			System.out.println("1. a) Kaksi säiettä ja molemmilla oma iteraattori.\n" +
								"2. b) Kaksi säiettä ja molemmat käyttävät samaa iteraattoria.\n" +
								"3. c) Tee muutoksia iteroinnin aikana.\n" +
								"4. d) Set iteraattorin testausta.");
			input = scanner.nextInt();
			System.out.println("Määrä?");
			int amount = scanner.nextInt();
			try {
				switch (input) {
					case 1:
						TwoIterators ti = new TwoIterators(amount);
						break;
					case 2:
						SharedIterator si = new SharedIterator(amount);
						break;
					case 3:
						ModifyWhileIterating mwi = new ModifyWhileIterating(amount);
						break;
					case 4:
						MessingWithIterators set = new MessingWithIterators(amount);
						break;

				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
