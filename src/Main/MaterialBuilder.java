package Main;

import java.lang.StringBuilder;

public class MaterialBuilder {
    //the point of this class is to shorten the amount of
    //text needed to register materials further

    //this will allow text files (or .csv) to be used to
    //input the data needed to output all of the zs scripting

    //a simple syntax will be used, only one line and minimal characters

    //boolean(?): 1 = true, 0 = false

    // type
    // compound?
    // name
    // localName
    // color
    // optional data values in this order: block; ore; smelt; composition
    //   otherwise use # to end if needed

    //these are separated by semicolons

    // ex: iron
    // 3; 0; iron; Iron; 101010; 6, 5, 2; 3, 3, 1; 6, 5, 1, 1, 1, 0
    // ex2: bronze
    // 2; 1; bronze; Bronze; 1059189; 6, 5, 2; 6, 5, 1, 1, 0, 0; copper * 3, tin
    //directly outputs the zs script lines for that material
    public static String build(String build) {
        StringBuilder sb = new StringBuilder();
        String b1 = build.replace(" ", "");
        String[] values = b1.split(";\\s*");


        return null;
    }

}
