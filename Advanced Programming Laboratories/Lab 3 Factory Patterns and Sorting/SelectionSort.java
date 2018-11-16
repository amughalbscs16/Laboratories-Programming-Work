/**
 * An implementation of the selection sort algorithm.
 */

public class SelectionSort implements SortingAlgorithm 
{

 public void sort(Object[] items) {
            int i, j, minPosition;
            for (i = 0; i < items.length - 1; i++) { 
                    minPosition = i;

                    for (j = i + 1; j < items.length; j++) { 
                            if( ((Comparable) items[j]).compareTo(items[minPosition]) < 0)  
                                    minPosition = j; 
                    } 


                    // exchange items[i] and items[minPosition]
                    Object t = items[i];
                    items[i] = items[minPosition];
                    items[minPosition] = t;

            } 
    }

}

