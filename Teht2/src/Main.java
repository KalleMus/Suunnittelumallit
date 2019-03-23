import factories.*;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {

	/**
	 * Kirjoita ohjelma, jossa Jasper pukee päällensä farmarit, t-paidan,
	 * lippiksen ja kengät. Tämän jälkeen Jasper luettelee ylpeänä, mitä hänellä on
	 * päällään (vaatekappaleet osaavat toString-metodeissaan kertoa kaiken oleellisen
	 * itsesätään.
	 */

	private static Scanner scanner = new Scanner(System.in);
	private static Properties prop = new Properties();
	private static InputStream configFile = null;
	private static ClothingFactory_IF clothingFactory = null;
	private static Class factoryClass = null;

	public static void main(String[] args) {
		mainLoop();
	}

	// Kontrolloitu looppi, jotta ohjelman ajonaikana tehdasta voi
	// vaihtaa muokkaamalla config.properties tiedostoa.
	private static void mainLoop() {

		// Jasper olion luonti.
		JavaKoodaaja jasper = new JavaKoodaaja("Jasper");

		// Loopin alku.
		int input = 1;
		while (input == 1) {

			// Tehtaan nimen hakeminen config.properties tiedostosta.
			try {
				configFile = new FileInputStream("src/config.properties");
				prop.load(configFile);

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			// Tehtaan luonti.
			try {
				String factoryName = prop.getProperty("FactoryName");
				factoryClass = Class.forName(factoryName);
				clothingFactory = (ClothingFactory_IF) factoryClass.getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Jos tehtaan haku onnistui.
			if (clothingFactory != null) {

				// Jasperin pukeutuminen.
				jasper.wearCap(clothingFactory.createCap());
				jasper.weartShirt(clothingFactory.createTshirt());
				jasper.wearJeans(clothingFactory.createJeans());
				jasper.wearShoes(clothingFactory.createShoes());

				// Jasperin tervehdys ja vaatteiden luettelu.
				System.out.println(jasper.greeting());
				System.out.println(jasper.wearingClothes());
			}

			// Jos tehtaan lataaminen ei onnistunut.
			else {
				System.out.println("Vaatetehdasta ei olla asetettu oikein.");
			}

			// Pyydä käyttäjää jatkamaan ohjelmaa.
			System.out.println("Voit muuttaa vaatetehdasta ajonaikana config.properties tiedostosta.");
			System.out.print("Syötä 1 jatkaaksesi ohjelmaa: ");
			input = scanner.nextInt();
		}
	}
}
