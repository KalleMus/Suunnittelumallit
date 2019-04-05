package main;

import java.util.Random;
import java.util.Scanner;

/**
 * Generates a list of given size and fills it whit randomly generated numbers.
 * The use can select which sorting algorithm to use for sorting.
 */
public class Main {

	private static final int BOUND = 10000;

	public static void main(String[] args) {
		mainLoop();
	}

	private static void mainLoop() {
		Random random = new Random();

		int input = -1;
		Scanner scanner = new Scanner(System.in);
		while (input != 0) {
			System.out.println("Number of data:");;
			int data = scanner.nextInt();
			MyArray array = new MyArray();
			for (int i = 0; i < data; i++) {
				array.insert(random.nextInt(BOUND), i);
			}

			System.out.println(
					"1) Bubble Sort\n" +
					"2) Insertion Sort\n" +
					"3) Selection Sort\n" +
					"0) Exit"
			);
			input = scanner.nextInt();

			switch (input) {
				case 1:
					array.setSortingStrategy(new BubbleSort());
					sortAndPrint(array);
					break;
				case 2:
					array.setSortingStrategy(new InsertionSort());
					sortAndPrint(array);
					break;
				case 3:
					array.setSortingStrategy(new SelectionSort());
					sortAndPrint(array);
					break;
			}
		}
	}

	private static void sortAndPrint(MyArray array) {
		array.sort();
		array.print();
		System.out.println("Algorithms effectiveness: " + array.numberOfComparisonsDoneByTheAlgorithm());
	}
}
