package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		/**
		 * Creating higher ups.
		 */
		Supervisor steve = new Supervisor("Steve");
		Manager mark = new Manager("Mark");
		CEO carl = new CEO("Carl");

		/**
		 * Establishing link between higher ups.
		 */
		steve.setNext(mark);
		mark.setNext(carl);

		/**
		 * Asking questions to create a new raise request form.
		 */
		System.out.println("Create a raise request");
		System.out.println("What is your name?");
		String name = scanner.next();
		System.out.println("What is your current salary in a month?");
		double currentWage = scanner.nextDouble();
		System.out.println("How much more would you like to earn in a month?");
		double raise = scanner.nextDouble();
		RaiseRequest request = new RaiseRequest(name, currentWage, raise);

		/**
		 * Handle the raise request.
		 */
		steve.handleRaiseRequest(request);
	}
}
