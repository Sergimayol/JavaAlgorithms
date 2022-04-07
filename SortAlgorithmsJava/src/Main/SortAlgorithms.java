package Main;

import Utilities.LinkedList;
import Utilities.Utilities;
import java.util.Arrays;
import java.util.Random;
import Sortalgorithms.MergeSort;
import Sortalgorithms.QuickSort;
import SetandMapping.UnsortedArraySet;
import java.util.Iterator;

/**
 *
 * @author Sergi
 */
public class SortAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new SortAlgorithms().quick();
        //new SortAlgorithms().merge();
        new SortAlgorithms().pruebas();
    }

    private void pruebas() {
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

    private void merge() {
        LinkedList l = new LinkedList();
        l.add(10);
        l.add(5);
        l.add(70);
        l.add(80);
        l.add(20);
        System.out.println(l.printList() + " Length: " + l.getLength());
        l.add(55);
        System.out.println(l.printList() + " Length: " + l.getLength());
        l.mergeSort();
        //l.quickSort();
        System.out.println(l.printList());
        Object[] a = l.toArray();
        System.out.println(Arrays.toString(a));
    }

    private void quick() {
        int[] valores = new int[15];
        valores[0] = 10;
        valores[1] = 100;
        valores[2] = 1000;
        valores[3] = 10000;
        valores[4] = 100000;
        valores[5] = 200000;
        valores[6] = 300000;
        valores[7] = 500000;
        valores[8] = 600000;
        valores[9] = 700000;
        valores[10] = 800000;
        valores[11] = 900000;
        valores[12] = 1000000;
        valores[13] = 1100000;
        valores[14] = 1500000;
        System.out.println("\ngenerateRandomArray");
        for (int i = 0; i < valores.length; i++) {
            ordenarQuickSort(valores[i], 0);
        }
        System.out.println("\ngenerateOrderedArray");
        for (int i = 0; i < valores.length; i++) {
            ordenarQuickSort(valores[i], 1);
        }
        System.out.println("\ngenerateInvertedArray");
        for (int i = 0; i < valores.length; i++) {
            ordenarQuickSort(valores[i], 2);
        }
    }

    private void ordenarQuickSort(int n, int op) {
        Integer[] l = null;
        switch (op) {
            case 0:
                l = (Integer[]) Utilities.generateRandomArray(n, 12, 1000);
                break;
            case 1:
                l = generateOrderedArray(n);
                break;
            case 2:
                l = generateInvertedArray(n);
                break;
            default:
                throw new AssertionError();
        }
//        System.out.println("");
//        System.out.println(Arrays.toString(l));
        QuickSort q = new QuickSort();
        long inicio = System.currentTimeMillis();
        q.sort(l);
        long fin = System.currentTimeMillis();
//        System.out.println(Arrays.toString(l));
        System.out.println("Length: " + n + "\nTiempo(ms): " + (fin - inicio));
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] lista = new Integer[n];
        Random ran;
        try {
            ran = new Random(12);
            for (int i = 0; i < lista.length; i++) {
                lista[i] = ran.nextInt(10000);
            }
            QuickSort q = new QuickSort();
            q.sort(lista);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return lista;
    }

    public static Integer[] generateInvertedArray(int n) {
        Integer[] lista = new Integer[n];
        Integer[] aux = new Integer[n];
        Random ran;
        try {
            ran = new Random(12);
            for (int i = 0; i < lista.length; i++) {
                lista[i] = ran.nextInt(10000);
            }
            QuickSort q = new QuickSort();
            q.sort(lista);
            int a = lista.length - 1;
            for (int i = 0; i < lista.length; i++) {
                aux[i] = lista[a];
                a--;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return aux;
    }

}