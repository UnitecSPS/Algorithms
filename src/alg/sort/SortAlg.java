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
public abstract class SortAlg {
    
    public abstract void Sort(Comparable[] items);
    
    protected void exchange(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    
    public static final int BUBBLE_SORT = 0;
    public static final int SELECTION_SORT = 1;
    public static final int INSERTION_SORT = 2;
    public static final int SHELL_SORT = 3;
    public static final int MERGE_SORT = 9;
    public static final int QUICK_SORT = 10;
	public static final int HEAP_SORT = 11;
}
