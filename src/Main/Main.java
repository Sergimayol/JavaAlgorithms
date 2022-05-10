package Main;

import BinarySearchTree.BSTMapping;
import Utilities.LinkedList;
import Utilities.Utilities;
import java.util.Arrays;
import java.util.Random;
import Sortalgorithms.MergeSort;
import Sortalgorithms.QuickSort;
import SetandMapping.UnsortedArraySet;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sergi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().test();
    }

    private void test() {
        UnsortedArraySet<Character> conjuntoLetras = new UnsortedArraySet(7);
        Random ran = new Random();
        for (int i = 0; i < 7; i++) {
            if (!conjuntoLetras.add((char) (ran.nextInt(26) + 'A'))) {
                i--;
            }
        }
        System.out.println(conjuntoLetras);
//        BSTMapping<String, Integer> mapping = new BSTMapping();
//        mapping.put("pal", 1);
//        System.out.println(mapping);
        Iterator it = conjuntoLetras.iterator();
        ArrayList<Character> arr = new ArrayList<>();
        while (it.hasNext()) {
            arr.add((Character) it.next());
        }
        Character c = arr.remove(0);
        conjuntoLetras = new UnsortedArraySet(7);
        Random rand = new Random();
        for (int i = 0; i < arr.size(); i++) {
            int randomIndexToSwap = rand.nextInt(arr.size());
            Character temp = arr.get(randomIndexToSwap);
            arr.set(randomIndexToSwap, arr.get(i));
            arr.set(i, temp);
        }
        conjuntoLetras.add(c);
        for (int i = 0; i < arr.size(); i++) {
            conjuntoLetras.add(arr.get(i));
        }
        System.out.println(conjuntoLetras);
    }

    private void moreTest() {
        UnsortedArraySet<String> diesSetmana = new UnsortedArraySet(5);
        diesSetmana.add("Lunes");
        diesSetmana.add("Martes");
        diesSetmana.add("Miercoles");
        diesSetmana.add("Domingo");
        diesSetmana.add("Jueves");
        diesSetmana.remove("Lunes");
        diesSetmana.remove("Martes");
        diesSetmana.add("Viernes");
        System.out.println(diesSetmana);
        Iterator it = diesSetmana.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        UnsortedArraySet<Character> c = new UnsortedArraySet(7);
        for (int i = 0; i < 8; i++) {
            Random random = new Random();
            c.add((char) (random.nextInt(26) + 'a'));
        }
        System.out.println(c);
    }

}
