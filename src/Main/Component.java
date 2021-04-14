package Main;

public class Component {
    //specifies the name and amount of each material in a compound definition
    int amount;
    Material name;

    public Component(Material name, int amount) {
        this.amount = amount;
        this.name = name;
    }

    public String toString() {
        return this.name + " * " + this.amount;
    }
}
