package Main;

public class Chemical {
    //naming is weird, but this is basically the identifier for
    //each known element in the periodic table
    String name; //eg: Hydrogen
    String symbol; //eg: H

    private Chemical() {
        
    }
    public Chemical (String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
