/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sortalgorithms;

import static Sortalgorithms.SortUtils.greater;
import static Sortalgorithms.SortUtils.swap;
import Utilities.Sort;

/**
 *
 * @author Sergi
 */
public class BubbleSort implements Sort {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 1, size = array.length; i < size; ++i) {
            boolean swapped = false;
            for (int j = 0; j < size - i; ++j) {
                if (greater(array[j], array[j + 1])) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

}
