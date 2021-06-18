package by.epam.shchemelev.sorts;

import by.epam.shchemelev.Array;

public interface Sortable {
    void sortStraight(Array array);
    void sortReverse(Array array);

    static void swap(Array array, int j1, int j2){
        int tmp = array.getArray()[j1];
        array.getArray()[j1] = array.getArray()[j2];
        array.getArray()[j2] = tmp;
    }
}
