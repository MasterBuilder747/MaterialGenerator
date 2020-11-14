package Main;

public class Material {

    //used in the material builder
    String name;
    String localName;
    int color;

    //determines what set of parts will be generated
    int type;

    boolean compound; //alloy, gem, mineral, ore dust
    //only if compound is true
    //f = physical, t = chemical
    boolean separation; //f = centrifuge t = electrolyzer
    boolean combination; //f = mixer t = chemical reactor

    //optional if type 2 or 3
    boolean conductive;
    boolean magnetic;
    boolean blast_furnace;


    public Material(String name, String localName, int color, int type) {
        this.name = name;
        this.localName = localName;
        this.color = color;
        this.type = type;
        this.compound = false;
    }

    public void setCompound(boolean separation, boolean combination) {
        this.compound = true;
        this.combination = combination;
        this.separation = separation;
    }

    public void setSmelting(boolean conductive, boolean magnetic, boolean blast_furnace) {
        if (this.type == 2 || this.type == 3) {
            this.conductive = conductive;
            this.magnetic = magnetic;
            this.blast_furnace = blast_furnace;
        }
    }

    public void build() {
        //generate parts here
        //generate machine recipes here as well?
    }
}
