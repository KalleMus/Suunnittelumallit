package factorymethod;

public abstract class AterioivaOtus {

    private Juoma juoma = null;
    private Ruoka ruoka = null;

    public abstract Juoma createJuoma();
    public abstract Ruoka createRuoka();


    public void aterioi(){
        syö();
        juo();
    }

    private void syö(){
        if (ruoka == null)
            ruoka = createRuoka();
        System.out.println("Kylläpä " + ruoka + " maistuukin hyvältä");
    }


    private void juo(){
        if (juoma == null)
            juoma = createJuoma();
        System.out.println("Aterian jälkeen " + juoma + " tekee terää");
    }
}
