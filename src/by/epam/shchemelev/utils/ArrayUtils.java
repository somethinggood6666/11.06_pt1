package by.epam.shchemelev.utils;

import by.epam.shchemelev.array.Array;
import by.epam.shchemelev.exceptions.ArrayExistencyException;

public class ArrayUtils {
    protected static void requireNotNullArray(Array array){
        if (array == null || array.getArray() == null){
            try {
                throw new ArrayExistencyException("Array should be not null");
            } catch (ArrayExistencyException e) {
                e.printStackTrace();
            }
        }
    }

    protected static int[] getCorrectArray(int[] array, int arraySize){
        int[] returnArray = new int[arraySize];
        int k1 = 0;
        for (int element : array) {
            if (element != 0) {
                returnArray[k1] = element;
                k1++;
            }
        }
        return returnArray;
    }

    protected static boolean isPrime(int number){
        if (number == 1) return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }

    protected static int elementMeetsTimes(Array array, int curNumber){
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
