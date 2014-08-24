/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alg.sort;

/**
 *
 * @author Benyair
 */
public class HeapSort extends SortAlg{
    
    public static int heapSize;
    
    public HeapSort(){ }
    
    @Override
    public void Sort(Comparable[] items){
        MaxHeap(items);
        
        for ( int i = (items.length-1); i >= 0; i-- ){
            Comparable temp = items[0];
            items[0] = items[i];
            items[i] = temp;
            
            heapSize--;
            
            MaxHeapify(items, 0);
        }
    }
    
    private void MaxHeapify(Comparable[] items, int index){
        int left = Left(index);
        int right = Right(index);
        int largestElement = -1;
        
        if( left < heapSize && items[left].compareTo(items[index]) > 0 )
            largestElement = left;
        else
            largestElement = index;
        
        if ( right < heapSize && items[right].compareTo(items[largestElement]) > 0 )
            largestElement = right;
        
        if ( largestElement != index ){
            Comparable temp = items[index];
            items[index] = items[largestElement];
            items[largestElement] = temp;
            MaxHeapify(items, largestElement);
        }
    }
    
    private void MaxHeap(Comparable[] items){
        heapSize = items.length;
        
        for ( int i = items.length/2; i >= 0; i-- )
            MaxHeapify(items, i);
    }
    
    private int Left(int index){
       return (2*index)+1; 
    }
    
    private int Right(int index){
        return (2*index)+2;
    }
    
}
