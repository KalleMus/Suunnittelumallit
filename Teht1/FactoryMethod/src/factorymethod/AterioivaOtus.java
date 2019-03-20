package factorymethod;

public abstract class AterioivaOtus {

    private Juoma juoma = null;

    public abstract Juoma createJuoma();


    public void aterioi(){
        syö();
        juo();
    }

    private void syö(){
        System.out.println("Kylläpä ruoka maistuukin hyvältä");
    }


    private void juo(){
        if (juoma == null)
            juoma = createJuoma();
        System.out.println("Aterian jälkeen " + juoma + " tekee terää");
    }
}
