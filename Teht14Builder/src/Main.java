import builder.BurgerBuilder_IF;
import builder.Hesburger;
import builder.McDonalds;
import burger_parts.BurgerParts_IF;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		mainLoop();
	}

	private static void mainLoop() {
		Burger_Director burgerDirector = new Burger_Director();
		int input = -1;
		Scanner scanner = new Scanner(System.in);
		while (input != 0) {
			System.out.println("-----MAKE YOUR BURGER-----\n");
			System.out.println("  1) Use Hesburger Builder");
			System.out.println("  2) Use Mc Donalds Builder");
			System.out.println("  0) Exit");
			input = scanner.nextInt();
			switch (input) {
				case 1:
					BurgerBuilder_IF hesburgerBuilder = new Hesburger();
					burgerDirector.setBurgerBuilder(hesburgerBuilder);
					burgerDirector.constructBurger();
					StringBuilder kerroshampurilainen = (StringBuilder) burgerDirector.getBurger();
					System.out.println(kerroshampurilainen.toString());
					break;

				case 2:
					BurgerBuilder_IF mcDonaldsBuilder = new McDonalds();
					burgerDirector.setBurgerBuilder(mcDonaldsBuilder);
					burgerDirector.constructBurger();
					List<BurgerParts_IF> bigMac = (List) burgerDirector.getBurger();
					bigMac.stream().forEach(part -> System.out.println(part.toString()));
					break;

				case 0:
					System.exit(0);

			}
		}
	}
}
