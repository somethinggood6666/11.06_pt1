package by.epam.shchemelev.sorts;

import by.epam.shchemelev.Array;

public class BubbleSort implements Sortable{
    @Override
    public void sortStraight(Array array) {
        for (int i = array.getArray().length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if (array.getArray()[j] > array.getArray()[j + 1]){
                    Sortable.swap(array, j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortReverse(Array array) {
        for (int i = array.getArray().length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if (array.getArray()[j] <= array.getArray()[j + 1]){
                    Sortable.swap(array, j, j + 1);
                }
            }
        }
    }
}
