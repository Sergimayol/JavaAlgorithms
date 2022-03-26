package Utilities;

import java.util.Random;

/**
 *
 * @author Sergi
 */
public class Utilities {

    public static Object[] generateRandomArray(int length, int seed, int range_values) {
        Object[] lista = new Object[length];
        Random ran;
        try {
            ran = new Random(seed);
            for (int i = 0; i < lista.length; i++) {
                lista[i] = ran.nextInt(range_values);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return lista;
    }

    public static Object[] reverseArray(Object[] l) {
        Object[] reverse = new Object[l.length];
        try {
            int a = l.length - 1;
            for (int i = 0; i < l.length; i++) {
                reverse[i] = l[a];
                a--;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return reverse;
    }

}
