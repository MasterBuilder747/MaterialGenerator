package Main;

public class Generator {

    public static final int DUST_ONLY = 0;
    public static final int ORE_ONLY = 1;
    public static final int SMELT_ONLY = 2;
    public static final int ORE_SMELT = 3;
    public static final int GEM_ONLY = 4;
    public static final int GEM_ORE = 5;

    public static void main(String[] args) {
        Material iron = new Material("iron", "Iron", 1110001, ORE_SMELT);
        iron.setSmelting(true, true, false);
        iron.build();
    }

}
