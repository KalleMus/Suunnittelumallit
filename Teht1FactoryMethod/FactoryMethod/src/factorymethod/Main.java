package factorymethod;

/**
 * Factory Method: Liitteenä on factorymethod.zip (NetBeans-projekti),
 * joka sisältää koodia, jossa AterioivaOtus aterioi.
 * Esimerkkiohjelman Juoma luodaan AterioivanOtuksen Opettaja-aliluokassa.
 * Juomanluontimetodi on tehdasmetodi. Kirjoita Opettaja-luokalle kaksi rinnakkaista luokkaa,
 * joissa kummassakin luodaan sopiva juoma.
 *
 * Luo testiohjelmassasi jokaista otustyyppiä oleva olio ja laita ne aterioimaan.
 */
public class Main {

    public static void main(String[] args) {

        // Luo testiohjelmassasi jokaista otustyyppiä oleva olio...
        AterioivaOtus opettaja = new Opettaja();
        AterioivaOtus oppilas = new Oppilas();
        AterioivaOtus vartija = new Vartija();

        // ja laita ne aterioimaan.
        opettaja.aterioi();
        oppilas.aterioi();
        vartija.aterioi();
    }
}
