/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.sort;
import java.util.Arrays;


/**
 *
 * @author ideras
 */
public class QuickShellSort extends SortAlg {

	ShellSort shell;
	
    public QuickShellSort() {
    	shell = new ShellSort();
	}

    @Override
    public void Sort(Comparable[] items) {
        if (items == null || items.length == 0) {
            return;
        }
        quickshellsort(items, 0, items.length - 1);
    }

    private void quickshellsort(Comparable[] items, int low, int high) {
        int i = low, j = high;
		
		if((high-low )<25)
		{
			shell.SortLowHigh(items,low, high);
			//return;
		}
		else
		{
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
			
			if (low < j) {
				quickshellsort(items, low, j);
			}
			if (i < high) {
				quickshellsort(items, i, high);
			}
		}
        
    }
    
}
