import data.ConcreteData;
import data.Data_IF;
import decorator.AdvancedDecoder;
import decorator.AdvancedEncoder;
import decorator.BasicDecoder;
import decorator.BasicEncoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	private static final String FILENAME = "data.txt";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		mainLoop();
	}

	/**
	 * In mainLoop you can choose to write new data to a file or read data from a file.
	 */
	private static void mainLoop() {
		int input = -1;
		while (input != 0) {
			System.out.println(
					"1) Write data \n" +
					"2) Read data \n" +
					"0) Exit"
			);
			input = scanner.nextInt();

			switch (input) {
				case 1:
					writeData();
					break;
				case 2:
					readData();
					break;
				case 0:
					System.exit(0);
			}
		}
	}

	/**
	 * In writeData you can write new data to a file and choose which encoding you want to use.
	 */
	private static void writeData() {
		System.out.println();
		System.out.println("---------write-data------------");
		System.out.println();
		Data_IF dataObj = null;
		System.out.println("Write your data here.");
		scanner.nextLine();
		String data = scanner.nextLine();
		int input = 0;
		while (dataObj == null) {
			System.out.println(
				"Choose encoding\n" +
				"1) None\n" +
				"2) Basic\n" +
				"3) Advanced"
			);
			input = scanner.nextInt();

			switch (input) {
				case 1:
					dataObj = new ConcreteData(data);
					break;

				case 2:
					dataObj = new BasicEncoder( new ConcreteData(data) );
					break;

				case 3:
					dataObj = new AdvancedEncoder( new ConcreteData(data) );
					break;
			}
		}
		writeToFile(dataObj.getData());
	}

	/**
	 * In readData you can read new data from a file and choose which decoding you want to use.
	 */
	private static void readData() {
		System.out.println();
		System.out.println("---------read-data------------");
		System.out.println();
		String data = readFromFile();
		System.out.println("Data read from the file:");
		System.out.println(data);
		System.out.println();
		Data_IF dataObj = null;
		int input = 0;
		while (dataObj == null) {
			System.out.println(
					"Choose decoding\n" +
							"1) None\n" +
							"2) Basic\n" +
							"3) Advanced"
			);
			input = scanner.nextInt();

			switch (input) {
				case 1:
					dataObj = new ConcreteData(data);
					break;

				case 2:
					dataObj = new BasicDecoder( new ConcreteData(data) );
					break;

				case 3:
					dataObj = new AdvancedDecoder( new ConcreteData(data) );
					break;
			}
		}
		System.out.println("Data after decoding:");
		System.out.println(dataObj.getData());
	}

	private static void writeToFile(String data) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));
			writer.write(data);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String readFromFile() {
		String data = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			data = reader.readLine();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
