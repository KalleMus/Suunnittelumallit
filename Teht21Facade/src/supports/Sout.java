package supports;

import java.util.concurrent.TimeUnit;

public class Sout {

	public static void print(String message, int delay) {
		try {
			System.out.println(message);
			TimeUnit.MILLISECONDS.sleep(delay);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dotPrint(String message, int delay) {
		printSL(message, delay);
		printDots(3, delay);
	}

	public static void dotPrintSL(String message, int delay) {
		printSL(message, delay);
		printDotsSL(3, delay);
	}

	public static void printDots(int amount, int delay) {
		for (int i = 0; i < amount; i++) {
			printSL(".", delay);
		}
		System.out.println();
	}

	public static void printDotsSL(int amount, int delay) {
		for (int i = 0; i < amount; i++) {
			printSL(".", delay);
		}
	}

	public static void printSL(String message, int delay) {
		try {
			System.out.print(message);
			TimeUnit.MILLISECONDS.sleep(delay);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
