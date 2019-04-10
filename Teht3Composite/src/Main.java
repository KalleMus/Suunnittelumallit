import Factories.PcFactory;
import components.Component;
import components.dell_components.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

/**
 * Composite: Suunnittele Composite-mallin mukaisesti rajapinnat ja toteutukset systeemille,
 * jolla voit esittää pöytätietokoneen kokoonpanon ja laskea sen hinnan, kun kukin
 * komponentti tietää oman hintansa.
 *
 * Idea on että tietokoneen kaikki osat ovat vaikkapa Laiteosa-rajapinnan toteuttajia.
 * Laiteosalla on hinta.
 *
 * Laiteosia on erilaisia, esim.
 * -muistipiiri
 * -emolevy
 * -verkkokortti
 * -näytönohjain
 * -kotelo
 *
 * Näistä ainakin emolevy ja kotelo ovat koostekomponentteja. Näiden hinta muodostuu
 * komponenttien omasta hinnasta sekä mahdollisen sisällön eli liitettyjen
 * komponenttien hinnasta.
 *
 * Esitä luokkahierarkia ja rakenna pöytätietokonekokoonpano haluamistasi osista
 * ja laske lopuksi kokoonpanon hinta ja tulosta se. Hinnan ilmoittava metodi
 * palauttaa hinnan metodin paluuarvona.
 *
 * Bonus:
 *
 * Esitä, kuinka voit luoda kaikki tuoteosat abstraktin tehtaan avulla.
 * Esitä myös, kuinka konkreettista tehdasta vaihtamalla saat helposti lasketuksi
 * eri tehtaiden tuottamien samanlaisten kokoonpanojen hintoja.
 */

public class Main {

	private static InputStream file;
	private static Properties prop = new Properties();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		mainLoop();
	}

	private static void mainLoop() {

		int input = 1;
		while (input == 1) {

			try {
				// Read property file.
				file = new FileInputStream("src/config.properties");
				prop.load(file);

				// Create a factory based on the FactoryName property.
				String factoryName = prop.getProperty("FactoryName");
				String factoryPath = "Factories.";
				Class factoryClass = Class.forName(factoryPath + factoryName);
				PcFactory pcFactory = (PcFactory) factoryClass.getDeclaredConstructor().newInstance();

				// Assemble Case.
				Component pcCase = pcFactory.createCase();
				pcCase.addComponent(pcFactory.createPowerSupply());
				pcCase.addComponent(pcFactory.createSSD());

				// Assemble motherboard.
				Component pcMotherBoard = pcFactory.createMotherboard();
				pcMotherBoard.addComponent(pcFactory.createGraphicsCard());
				pcMotherBoard.addComponent(pcFactory.createRAM());

				// Insert motherboard into the case.
				pcCase.addComponent(pcMotherBoard);

				// Print out price:
				System.out.println("Price of the pc from the " + factoryName + " is: " + pcCase.getPrice());


			} catch (Exception e) {
				e.printStackTrace();
			}

			// Controlled loop.
			System.out.println("Insert 1 to continue.");
			input = scanner.nextInt();
		}
	}
}
