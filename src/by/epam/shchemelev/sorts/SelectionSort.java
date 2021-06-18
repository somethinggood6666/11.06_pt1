package by.epam.shchemelev.sorts;

import by.epam.shchemelev.array.Array;

public class SelectionSort implements Sortable{
    @Override
    public void sortStraight(Array array) {
        int n = array.getArray().length;
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (array.getArray()[j] < array.getArray()[min_idx]) {
                    min_idx = j;
                }
            Sortable.swap(array, min_idx, i);
        }
    }

    @Override
    public void sortReverse(Array array) {
        int n = array.getArray().length;
        for(int i = 0; i < n - 1; i++){
            int max_idx = i;
            for(int j = i + 1; j < n; j++)
                if(array.getArray()[j] > array.getArray()[max_idx])
                    max_idx = j;
            Sortable.swap(array, max_idx, i);
        }
    }
}
