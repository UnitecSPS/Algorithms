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
public class SelectionSort extends SortAlg {

    @Override
    public void Sort(Comparable[] items) {
        for (int i = 0; i < items.length - 1; i++) {
            int minIndex = i;      // Index of smallest remaining value.
            for (int j = i + 1; j < items.length; j++) {
                if (items[minIndex].compareTo(items[j]) > 0) {
                    minIndex = j;  // Remember index of new minimum
                }
            }
            if (minIndex != i) {
                //Exchange current element with smallest remaining.
                exchange(items, i, minIndex);
            }
        }
    }

}
