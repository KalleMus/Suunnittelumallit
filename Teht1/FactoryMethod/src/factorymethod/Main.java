package factorymethod;

public class Main {

    public static void main(String[] args) {
        AterioivaOtus opettaja = new Opettaja();
        AterioivaOtus oppilas = new Oppilas();
        AterioivaOtus vartija = new Vartija();

        opettaja.aterioi();
        oppilas.aterioi();
        vartija.aterioi();
    }
}
