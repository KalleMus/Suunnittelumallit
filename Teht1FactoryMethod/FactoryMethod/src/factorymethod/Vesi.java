package factorymethod;

public class Vesi implements Juoma {

    private String name = "vesi";

    @Override
    public String toString() {
        return this.name;
    }
}
