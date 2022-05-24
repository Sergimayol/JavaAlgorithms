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
import MVA.MeanValueAnalysis;

/**
 *
 * @author Sergi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // new Main().test();
    }

    private void test() {
        int N = 3 + 1;
        int Z = 5;
        int K = 3;
        double[] Si = { 0.03, 0.5, 0.0 };
        int[] Vi = { 15, 14, 0 };
        MeanValueAnalysis mva = new MeanValueAnalysis();
        mva.MVA(N, Z, K, Si, Vi);
    }
}
