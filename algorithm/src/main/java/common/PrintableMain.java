package common;

import java.util.Arrays;

/**
 * Created by Choen-hee Park
 * User : chpark
 * Date : 14/08/2020
 * Time : 1:15 AM
 */
public class PrintableMain {
    protected static <T, F> void printResult(T input, F function) {
        if (input instanceof Object[] ) {
            System.out.println("input:<" + Arrays.toString((Object[])input) + ">\t/ result:<" + function + ">");
        } else {
            System.out.println("input:<" + input + ">\t/ result:<" + function + ">");
        }
    }
}
