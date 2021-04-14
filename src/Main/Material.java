package Main;

import java.lang.StringBuilder;

public class Material {

    //used in the material builder
    String name;
    String localName;
    int color;

    //determines what set of parts will be generated
    int type;

    //only if compound is true
    //f = physical, t = chemical
    boolean compound = false; //alloy, gem, mineral, ore dust
    Component[] components;
    int separation; //-1 = chemical, 1 = physical separation/combination, 0 is none
    int combination; //-1 = chemical, 1 = physical separation/combination, 0 is none

    //if type 2 or 3
    int frameHardness = 5;
    int frameResistance = 6;
    int frameLevel = 1;
    boolean conductive = false;
    boolean magnetic = false;
    boolean blast_furnace = false;

    //if type 1, 3, or 5
    int oreHardness = 3;
    int oreResistance = 3;
    int oreLevel = 1;

    //if type 2-5
    int blockHardness = 5;
    int blockResistance = 6;
    int blockLevel = 1;


    //zs code strings
    String build;
    String partReg;
    String compoundReg = "";
    String optionalReg = "";


    public Material(String name, String localName, int color, int type) {
        this.name = name;
        this.localName = localName;
        this.color = color;
        this.type = type;
    }

    public void setCompound(String composition, int separation, int combination) {
        this.compound = true;
        //syntax: name * amount,name*amount, ...
        String comp = composition.replace(" ", "");
        String[] parts = comp.split(",\\s*");
        int[] amounts = new int[parts.length];
        String[] materials = new String[parts.length]; //uses the name string of materials
        this.components = new Component[parts.length];
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].contains("*")) {
                materials[i] = parts[i].substring(0, parts[i].indexOf("*"));
                amounts[i] = Integer.parseInt(parts[i].substring(parts[i].indexOf("*") + 1));
            } else {
                materials[i] = parts[i];
                amounts[i] = 1;
            }
            if (Reg.get(materials[i]) != null) {
                components[i] = new Component(Reg.get(materials[i]), amounts[i]);
            } else {
                throw new IllegalArgumentException("Material " + materials[i] + " does not exist.");
            }
        }

        this.combination = combination;
        this.separation = separation;
    }

    //2 and 3
    public void setSmelting(int frameHardness, int frameResistance, int frameLevel, boolean conductive, boolean magnetic, boolean blast_furnace) {
        this.frameHardness = frameHardness;
        this.frameResistance = frameResistance;
        this.frameLevel = frameLevel;
        this.conductive = conductive;
        this.magnetic = magnetic;
        this.blast_furnace = blast_furnace;
    }

    //1, 3, 5
    public void setOre(int oreHardness, int oreResistance, int oreLevel) {
        this.oreHardness = oreHardness;
        this.oreResistance = oreResistance;
        this.oreLevel = oreLevel;
    }

    //3-5
    public void setBlock(int blockHardness, int blockResistance, int blockLevel) {
        this.blockHardness = blockHardness;
        this.blockResistance = blockResistance;
        this.blockLevel = blockLevel;
    }

    public void build() {
        //build the material
        this.build = "var " + this.name + " = MaterialSystem.getMaterialBuilder().setName(\"" + this.localName + "\").setColor(" + this.color + ").build();\n";

        //part registration
        StringBuilder sb = new StringBuilder();
        //case 0: dust only
        sb.append(this.name).append(".registerParts(dust_parts);\n");
        switch (this.type) {
            //ore only
            case 1 -> sb.append(this.name).append(".registerParts(ore_parts);\n");
            //smelt only
            case 2 -> sb.append(this.name).append(".registerParts(smelting_parts);\n");
            //ore and smelting
            case 3 -> {
                sb.append(this.name).append(".registerParts(smelting_parts);\n");
                sb.append(this.name).append(".registerParts(ore_parts);\n");
            }
            //gem only
            case 4 -> sb.append(this.name).append(".registerParts(gem_parts);\n");
            //gem and ore
            case 5 -> {
                sb.append(this.name).append(".registerParts(gem_parts);\n");
                sb.append(this.name).append(".registerParts(ore_parts);\n");
            }
        }
        this.partReg = sb.toString();

        //generate machine recipes here as well?
    }

    public String toString() {
        return this.build + this.partReg;
    }

    public void outputComponents() {
        if (this.compound) {
            StringBuilder sb = new StringBuilder();
            for (Component component : this.components) {
                sb.append(component.name);
                sb.append(" x ");
                sb.append(component.amount);
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}
