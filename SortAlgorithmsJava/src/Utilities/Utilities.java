package Utilities;

import java.util.Arrays;
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
            System.out.println(Arrays.toString(e.getStackTrace()));
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
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return reverse;
    }

    public static LinkedList generateRandomIntegerLinkedList(int length, int seed, int range_values) {
        LinkedList list = null;
        Random ran;
        try {
            ran = new Random(seed);
            list = new LinkedList();
            for (int i = 0; i < length; i++) {
                list.add(ran.nextInt(range_values));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return list;
    }

    public static int[] shuffleArray(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
