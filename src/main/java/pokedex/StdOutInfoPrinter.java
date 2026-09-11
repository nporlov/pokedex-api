package pokedex;

public class StdOutInfoPrinter implements InfoPrinter {
    @Override
    public void printInfo(Object data) {
        System.out.println(data.toString());
    }
}
