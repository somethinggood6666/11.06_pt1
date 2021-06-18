package by.epam.shchemelev.array;

import by.epam.shchemelev.utils.ArrayFiller;
import by.epam.shchemelev.sorts.BubbleSort;
import by.epam.shchemelev.sorts.InsertionSort;
import by.epam.shchemelev.sorts.SelectionSort;
import by.epam.shchemelev.sorts.Sortable;
import by.epam.shchemelev.utils.ArrayUtils;

import java.io.FileNotFoundException;

public class Array extends ArrayUtils{
    private int[] array;

    public Array() {
    }

    public Array(int... vars) {
        this.array = new int[vars.length];
        System.arraycopy(vars, 0, array, 0, vars.length);
    }

    public Array(byte[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public Array(short[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public Array(double[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = (int)Math.round(array[i]);
        }
    }

    public Array(char[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }

    public Array(Array array) {
        this.array = new int[array.getArray().length];
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = array.getArray()[i];
        }
    }

    public static void fillArrayWithRandomNumbers(Array array){
        requireNotNullArray(array);
        ArrayFiller.fillArrayWithRandomNumbers(array);
    }

    public static void fillArrayWithConsole(Array array){
        requireNotNullArray(array);
        ArrayFiller.fillArrayWithConsole(array);
    }

    public static void fillArrayWithFile(Array array) throws FileNotFoundException {
        requireNotNullArray(array);
        ArrayFiller.fillArrayWithFile(array);
    }

    private static void performSorting(Array array, Sortable sort, String sortType) {
        requireNotNullArray(array);
        if (sortType.equalsIgnoreCase("straight")){
            sort.sortStraight(array);
            return;
        }
        if (sortType.equalsIgnoreCase("reverse")){
            sort.sortReverse(array);
            return;
        }
        badSortTypeFormat();
    }

    public static void selectionSort(Array array, String sortType){
        Sortable sort = new SelectionSort();
        performSorting(array, sort, sortType);
    }

    public static void insertionSort(Array array, String sortType){
        Sortable sort = new InsertionSort();
        performSorting(array, sort, sortType);
    }

    public static void bubbleSort(Array array, String sortType){
        Sortable sort = new BubbleSort();
        performSorting(array, sort, sortType);
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public static int getElementByBinarySearch(Array array, int elementToSearch){
        requireNotNullArray(array);
        int firstIndex = 0;
        int lastIndex = array.getArray().length - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array.getArray()[middleIndex] == elementToSearch) {
                return middleIndex;
            }
            else if (array.getArray()[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            }
            else {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int getMinimalElement(Array array){
        requireNotNullArray(array);
        int minimalIndex = 0;
        for (int i = 1; i < array.getArray().length; i++) {
            if (array.getArray()[i] < array.getArray()[minimalIndex]){
                minimalIndex = i;
            }
        }
        return array.getArray()[minimalIndex];
    }

    public static int getMaximalElement(Array array){
        requireNotNullArray(array);
        int maximalIndex = 0;
        for (int i = 1; i < array.getArray().length; i++) {
            if (array.getArray()[i] > array.getArray()[maximalIndex]){
                maximalIndex = i;
            }
        }
        return array.getArray()[maximalIndex];
    }


    public static int[] findPrimeNumbers(Array array){
        requireNotNullArray(array);
        int[] primes = new int[array.getArray().length];
        int k = 0;
        for (int i = 0; i < array.getArray().length; i++) {
            if (isPrime(array.getArray()[i])){
                primes[k] = array.getArray()[i];
                k++;
            }
        }
        return getCorrectArray(primes, k);
    }

    public static int[] findFibNumbers(Array array){
        requireNotNullArray(array);

        int prevNumber = 0;
        int prevPrevNumber = 0;
        int currentNumber = 0;
        int maxValue = getMaximalElement(array);

        int[] fibNumbers = new int[array.getArray().length];
        int index = 0;

        while (currentNumber < maxValue){
            currentNumber = (currentNumber == 1) ? 2 : prevNumber + prevPrevNumber;
            int count = elementMeetsTimes(array, currentNumber);
            if (count > 0){
                for (int i = 0; i < count; i++) {
                    fibNumbers[index] = currentNumber;
                    index++;
                }
            }
            prevPrevNumber = prevNumber;
            prevNumber = (currentNumber == 0) ? 1 : currentNumber;
        }

        return getCorrectArray(fibNumbers, index);
    }

    public static int[] findThreeDigitsNumber(Array array){
        requireNotNullArray(array);
        int[] nums = new int[array.getArray().length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (array.getArray()[i] > 100 && array.getArray()[i] < 999) {
                int hundreds = array.getArray()[i] / 100;
                int tenners = array.getArray()[i] / 10 % 10;
                int units = array.getArray()[i] % 10 ;

                if (hundreds != tenners && tenners != units) {
                    nums[k] = array.getArray()[i];
                    k++;
                }
            }
        }
        return getCorrectArray(nums, k);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Array array1 = (Array) object;

        int length = array1.getArray().length;

        for (int i = 0; i < length; i++) {
            if (array1.getArray()[i] != getArray()[i]){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        for (int num: getArray()){
            result = 37 * result + num;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Array consists of: ");
        for (int val: getArray()) {
            stringBuilder.append(val);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
