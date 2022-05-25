package Main;

import DynamicProgramming.Fibonacci;
import Backtraking.NQueensUS;
import BinarySearchTree.BSTMapping;
import DataStructures.LinkedList;
import Utilities.Utilities;
import java.util.Arrays;
import java.util.Random;
import Sortalgorithms.MergeSort;
import Sortalgorithms.QuickSort;
import SetandMapping.UnsortedArraySet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import MVA.MeanValueAnalysis;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new Main().test1();
            new Main().test2();
            new Main().test3();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void test1() {
        System.out.println("--------- TEST 1 ---------");
        int N = 3 + 1;
        int Z = 5;
        int K = 2;
        double[] Si = {0.03, 0.5};
        int[] Vi = {15, 14};
        MeanValueAnalysis mva = new MeanValueAnalysis();
        mva.MVA(N, Z, K, Si, Vi);
    }

    private void test2() {
        System.out.println("\n\n\n--------- TEST 2 ---------");
        int N = 3 + 1;
        int Z = 5;
        int K = 3;
        double[] Si = {0.03, 0.04, 0.04};
        int[] Vi = {17, 6, 10};
        MeanValueAnalysis mva = new MeanValueAnalysis();
        mva.MVA(N, Z, K, Si, Vi);
    }

    private void test3() {
        System.out.println("\n\n\n--------- TEST 3 ---------");
        int N = 3 + 1;
        int Z = 5;
        int K = 3;
        double[] Si = {0.02, 0.04, 0.1};
        int[] Vi = {11, 8, 2};
        MeanValueAnalysis mva = new MeanValueAnalysis();
        mva.MVA(N, Z, K, Si, Vi);
    }

}
