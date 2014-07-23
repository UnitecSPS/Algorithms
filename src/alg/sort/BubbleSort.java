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
public class BubbleSort extends SortAlg {

    public BubbleSort() { }

    @Override
    public void Sort(Comparable[] items) {
        int n = items.length;
        for (int pass = 1; pass < n; pass++) {  // count how many times
            // This next loop becomes shorter and shorter
            for (int i = 0; i < n - pass; i++) {
                if (items[i].compareTo(items[i + 1]) > 0) {
                    // Exchange elements
                    exchange(items, i, i+1);
                }
            }
        }
    }

}
