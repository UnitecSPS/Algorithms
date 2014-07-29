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
public class ShellSort extends SortAlg {

    private int gaps[]  = {701, 301, 132, 57, 23, 10, 4, 1};
    
    public ShellSort() {
    }

    @Override
    public void Sort(Comparable[] items) {
        

        for(int gap : gaps)
        {
            for (int i = gap; i < items.length; i += 1)
            {
                
                Comparable temp = items[i];
                int j = i;
                for ( ; j >= gap && items[j - gap].compareTo(temp)>0; j -= gap)
                {
                    items[j] = items[j - gap];
                }
                //# put temp (the original a[i]) in its correct location
                items[j] = temp;
            }

        }
    }
    
    public void SortLowHigh(Comparable[] items, int low, int high) {
    	for(int gap : gaps)
        {
            for (int i = (gap+(low-1)); i <= high; i += 1)
            {
                
                Comparable temp = items[i];
                int j = i;
                for ( ; j >= gap && items[j - gap].compareTo(temp)>0; j -= gap)
                {
                    items[j] = items[j - gap];
                }
                //# put temp (the original a[i]) in its correct location
                items[j] = temp;
            }

        }
    	
    }
    
}
