package Main;

import Backtraking.NQueensUS;
import BinarySearchTree.BSTMapping;
import Utilities.LinkedList;
import Utilities.Utilities;
import java.util.Arrays;
import java.util.Random;
import Sortalgorithms.MergeSort;
import Sortalgorithms.QuickSort;
import SetandMapping.UnsortedArraySet;
import java.util.ArrayList;
import java.util.Collections;
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
        //new Main().test();
        //new Main().test2();
    }

    private void test() {
        String aux = "Hola";
        String a = String.valueOf('a');
        System.out.println(aux.contains(a));

        UnsortedArraySet<Character> conjuntoLetras = new UnsortedArraySet(7);
        Random ran = new Random();
        for (int i = 0; i < 7; i++) {
            if (!conjuntoLetras.add((char) (ran.nextInt(26) + 'A'))) {
                i--;
            }
        }
        System.out.println(conjuntoLetras);
        BSTMapping<String, Integer> mapping = new BSTMapping();
        mapping.put("pal", 1);
        mapping.put("ff", 3);
        mapping.put("palss", 7);
        System.out.println(mapping);
        Iterator e = mapping.iterator();
//        while (e.hasNext()) {
//            mapping.get(a);
//        }
        System.out.println(mapping.get("ff"));
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

    private void test2() {
        ArrayList a = new ArrayList();
        a.add("a");
        a.add("cd");
        a.add("b");
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);
    }
    
}
