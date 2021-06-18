package by.epam.shchemelev.sorts;

import by.epam.shchemelev.Array;

public class InsertionSort implements Sortable {

    @Override
    public void sortStraight(Array array) {
        for (int left = 0; left < array.getArray().length; left++) {
            int value = array.getArray()[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array.getArray()[i]) {
                    array.getArray()[i + 1] = array.getArray()[i];
                } else {
                    break;
                }
            }
            array.getArray()[i + 1] = value;
        }
    }

    @Override
    public void sortReverse(Array array) {
        for (int left = 0; left < array.getArray().length; left++) {
            int value = array.getArray()[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value > array.getArray()[i]) {
                    array.getArray()[i + 1] = array.getArray()[i];
                } else {
                    break;
                }
            }
            array.getArray()[i + 1] = value;
        }
    }

}
