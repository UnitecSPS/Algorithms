/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.sort;

/**
 *
 * @author ideras
 */
public class QuickSort extends SortAlg {

    public QuickSort() {}

    @Override
    public void Sort(Comparable[] items) {
        if (items == null || items.length == 0) {
            return;
        }
        quicksort(items, 0, items.length - 1);
    }

    private void quicksort(Comparable[] items, int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        Comparable pivot = items[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            while (items[i].compareTo(pivot) < 0) {
                i++;
            }

            while (items[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                exchange(items, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j) {
            quicksort(items, low, j);
        }
        if (i < high) {
            quicksort(items, i, high);
        }
    }

}
