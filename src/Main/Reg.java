package Main;

import java.util.ArrayList;

public class Reg {

    /*
    public static final int DUST_ONLY = 0;
    public static final int ORE_ONLY = 1;
    public static final int SMELT_ONLY = 2;
    public static final int ORE_SMELT = 3;
    public static final int GEM_ONLY = 4;
    public static final int GEM_ORE = 5;
    */

    private static final ArrayList<Material> materials = new ArrayList<>();
    private static final ArrayList<Chemical> chemicals = new ArrayList<>();

    public static void addMat(Material m) {
        materials.add(m);
    }
    public static void addChem(Chemical c) {
        chemicals.add(c);
    }

    public static Material getMat(String name) {
        for (Material m : materials) {
            if (m.name.contains(name)) {
                return m;
            }
        }
        return null;
    }
    public static Chemical getChem(String name) {
        for (Chemical c : chemicals) {
            if (c.name.contains(name)) {
                return c;
            }
        }
        return null;
    }
}