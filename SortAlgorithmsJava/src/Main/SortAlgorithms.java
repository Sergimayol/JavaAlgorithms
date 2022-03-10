/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Arrays;
import java.util.Random;
import sortalgorithms.QuickSort;

/**
 *
 * @author Sergi
 */
public class SortAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new SortAlgorithms().inicio();
    }

    private void inicio() {
        ordenar(10);
        ordenar(100);
        ordenar(1000);
        ordenar(10000);
        ordenar(100000);
        ordenar(200000);
        ordenar(300000);
        ordenar(500000);
        ordenar(600000);
    }

    private void ordenar(int n) {
        Integer[] l = generateRandomArray(n);
        QuickSort q = new QuickSort();
        long inicio = System.currentTimeMillis();
        q.sort(l);
        long fin = System.currentTimeMillis();
        System.out.println("Length: " + n + "\nTiempo(ms): " + (fin - inicio));
    }

    public static Integer[] generateRandomArray(int n) {
        Integer[] lista = new Integer[n];
        Random ran;
        try {
            ran = new Random(12);
            for (int i = 0; i < lista.length; i++) {
                lista[i] = ran.nextInt(10000);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return lista;
    }
}
