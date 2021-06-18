package by.epam.shchemelev.utils;

import by.epam.shchemelev.Array;
import by.epam.shchemelev.exceptions.ArrayExistencyException;
import by.epam.shchemelev.exceptions.InvalidDataException;

public class ArrayUtils {
    public static void requireNotNullArray(Array array){
        if (array == null || array.getArray() == null){
            try {
                throw new ArrayExistencyException("Array should be not null");
            } catch (ArrayExistencyException e) {
                e.printStackTrace();
            }
        }
    }

    public static int[] getCorrectArray(int[] array, int k){
        int[] returnArray = new int[k];
        int k1 = 0;
        for (int element : array) {
            if (element != 0) {
                returnArray[k1] = element;
                k1++;
            }
        }
        return returnArray;
    }

    public static boolean isPrime(int number){
        if (number == 1) return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    protected static void badSortTypeFormat() {
        try {
            throw new InvalidDataException("Sort type given in wrong format");
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public static int elementMeetsTimes(Array array, int curNumber){
        int[] arr = array.getArray();
        int k = 0;
        for (int j : arr) {
            if (j == curNumber) {
                k++;
            }
        }
        return k;
    }
}
