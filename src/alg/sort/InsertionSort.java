package alg.sort;

/**
 *
 * @author ideras
 */
public class InsertionSort extends SortAlg {

    public InsertionSort() {}

    @Override
    public void Sort(Comparable[] items) {
        for (int i = 0; i < items.length; i++) {
            Comparable x = items[i];
            int j = i;
            while ( (j > 0) && (items[j - 1].compareTo(x) > 0) ) {
                items[j] = items[j - 1];
                j = j - 1;
            }
            items[j] = x;
        }
    }

}
