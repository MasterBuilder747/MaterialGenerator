package Main;

public class Generator {

    //material types
    public static final int DUST_ONLY = 0;
    public static final int ORE_ONLY = 1;
    public static final int SMELT_ONLY = 2;
    public static final int ORE_SMELT = 3;
    public static final int GEM_ONLY = 4;
    public static final int GEM_ORE = 5;

    //hardness, resistance, mining level
    public static final int NONE = 0;
    public static final int CHEMICAL = -1;
    public static final int PHYSICAL = 1;

    //ore, block, smelt, smeltMiscProps
    public static void main(String[] args) {

        //block, ore, smelt, compound

        Material iron = new Material("iron", "Iron", 1101011, ORE_SMELT);
        iron.setBlock(6, 5, 2);
        iron.setOre(3, 3, 1);
        iron.setSmelting(6, 5, 1, true, true, false);
        iron.build();
        Reg.addMat(iron);
        //System.out.println(iron.toString());

        Material coal = new Material("coal", "Coal", 0, GEM_ORE);
        coal.setBlock(6, 5, 2);
        coal.setOre(3, 3, 1);
        coal.build();
        Reg.addMat(coal);

        Material steel = new Material("steel", "Steel", 104718047, SMELT_ONLY);
        steel.setCompound("iron, coal * 4", 0, 0);
        steel.setBlock(6, 5, 2);
        steel.build();
        steel.outputComponents();
        Reg.addMat(steel);

        Material bronze = new Material("bronze", "Bronze", 1051805, SMELT_ONLY);
        //bronze.setCompound(new Component[]{new Component("copper", 3), new Component("tin", 1)}, false, false);
    }

}
