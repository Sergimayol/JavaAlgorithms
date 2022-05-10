package Utilities;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Sergi
 */
public class Utilities {

    /**
     * Generates an array with random numbers
     *
     * @param length
     * @param seed
     * @param range_values
     * @return array filled with random numbers
     */
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

    /**
     * Reverses and array
     *
     * @param list
     * @return reverse array
     */
    public static Object[] reverseArray(Object[] list) {
        Object[] reverse = new Object[list.length];
        try {
            int a = list.length - 1;
            for (int i = 0; i < list.length; i++) {
                reverse[i] = list[a];
                a--;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return reverse;
    }

    /**
     * Generates a linkedlist with random numbers
     *
     * @param length
     * @param seed
     * @param range_values
     * @return LinkedList filled with random numbers
     */
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

    /**
     * Shuffles an array
     *
     * @param arr
     * @return shuffled array
     */
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
