package by.epam.shchemelev;

import by.epam.shchemelev.exceptions.ArrayExistencyException;
import by.epam.shchemelev.exceptions.InvalidDataException;
import by.epam.shchemelev.exceptions.InvalidNumberException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Array {
    private int[] array;

    // CONSTRUCTORS
    public Array() {
    }

    public Array(int... vars) {
        this.array = new int[vars.length];
        for (int i = 0; i < vars.length; i++) {
            array[i] = vars[i];
        }
//        System.arraycopy(vars, 0, array, 0, array.length);
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

    // FILL ARRAY

    public static void fillArrayWithRandomNumbers(Array array, int length){
        requireNotNullArray(array);
        int[] arr = new int[length];
        int k = 0;

        for (int i = 0; i < length; i++) {
            arr[k] = (int)(Math.random() * 100);
        }
        array.setArray(arr);
    }

    public static void fillArrayWithConsole(Array array){
        requireNotNullArray(array);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array size");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            System.out.println("Enter " + (i + 1) + " element: ");
            Scanner scanner1 = new Scanner(System.in);
            String num = scanner1.nextLine();
            if (num.matches("[-+]?\\d+")){
                arr[k] = Integer.parseInt(num);
            } else {
                try {
                    throw new InvalidNumberException("Number has wrong format");
                } catch (InvalidNumberException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

    public static void fillArrayWithFile(Array array, String path) throws FileNotFoundException {
        requireNotNullArray(array);
        if (path.isEmpty()){
            try {
                throw new InvalidDataException("Path should be not null");
            } catch (InvalidDataException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        File file = new File(path);

        Scanner s = new Scanner(file);
        int size = s.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            if (s.hasNext()) {
                arr[i] = s.nextInt();
            } else {
                try {
                    throw new InvalidDataException("Not enough elements");
                } catch (InvalidDataException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
        array.setArray(arr);
    }

    // SORTS

    public static void bubbleSortStraight(Array array){
        requireNotNullArray(array);
        for (int i = array.getArray().length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if (array.getArray()[j] > array.getArray()[j + 1]){
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortReverse(Array array){
        requireNotNullArray(array);
        for (int i = array.getArray().length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if (array.getArray()[j] <= array.getArray()[j + 1]){
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void selectionSortStraight(Array array){
        requireNotNullArray(array);
        int n = array.getArray().length;
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (array.getArray()[j] < array.getArray()[min_idx]) {
                    min_idx = j;
                }
            swap(array, min_idx, i);
        }
    }

    public static void selectionSortReverse(Array array){
        requireNotNullArray(array);
        int n = array.getArray().length;
        for(int i = 0; i < n - 1; i++){
            int max_idx = i; // max_idx instead of min_idx
            for(int j = i + 1; j < n; j++)
                if(array.getArray()[j] > array.getArray()[max_idx]) // > instead of <
                    max_idx = j;
            swap(array, max_idx, i);
        }
    }
    
    public static void insertionSortStraight(Array array){
        requireNotNullArray(array);
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

    public static void insertionSortReverse(Array array){
        requireNotNullArray(array);
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

    private static void swap(Array array, int j1, int j2){
        int tmp = array.getArray()[j1];
        array.getArray()[j1] = array.getArray()[j2];
        array.getArray()[j2] = tmp;
    }


    // GETTER AND SETTER

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    // SEARCH ELEMENT

    public static int findElement(Array array, int elementToSearch){
        requireNotNullArray(array);
        if (!isArraySortedStraight(array)){
            try {
                throw new InvalidDataException("Array must be sorted straight to find the element with binary search");
            } catch (InvalidDataException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        int firstIndex = 0;
        int lastIndex = array.getArray().length - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array.getArray()[middleIndex] == elementToSearch) {
                return middleIndex;
            }
            else if (array.getArray()[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (array.getArray()[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;
        }
        return -1;
    }

    public static boolean isArraySortedStraight(Array array){
        for (int i = 0; i < array.getArray().length - 1; i++) {
            if (array.getArray()[i] > array.getArray()[i + 1]){
                return false;
            }
        }
        return true;
    }

    // FIND MINIMAL AND MAXIMAL ELEMENTS

    public static int findMinimalElement(Array array){
        requireNotNullArray(array);
        int minimalIndex = 0;
        for (int i = 1; i < array.getArray().length; i++) {
            if (array.getArray()[i] < array.getArray()[minimalIndex]){
                minimalIndex = i;
            }
        }
        return array.getArray()[minimalIndex];
    }

    public static int findMaximalElement(Array array){
        requireNotNullArray(array);
        int maximalIndex = 0;
        for (int i = 1; i < array.getArray().length; i++) {
            if (array.getArray()[i] > array.getArray()[maximalIndex]){
                maximalIndex = i;
            }
        }
        return array.getArray()[maximalIndex];
    }

    // PRIME NUMBER

    public static boolean isPrime(int number){
        if (number == 1) return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
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

    // FIBONACCHI NUMBERS

    public static int[] findFibNumbers(Array array){
        requireNotNullArray(array);
        if (!isArraySortedStraight(array)){
            try {
                throw new InvalidDataException("Array must be sorted straight to find fibonachi numbers");
            } catch (InvalidDataException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        int[] fibs = new int[array.getArray().length];
        int k = 0;

        int curNumber = 0;
        int prevNumber = 1;
        int nextNumber = 0;
        while (curNumber < Array.findMaximalElement(array)){

            if (findElement(array, nextNumber) != -1){
                fibs[k] = curNumber;
                k++;
            }
            nextNumber = curNumber + prevNumber;
            prevNumber = curNumber;
            curNumber = nextNumber;

        }
        return getCorrectArray(fibs, k);
    }

    // 3DIGITS NUMBERS

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


    // TOOLS

    public static void requireNotNullArray(Array array){
        if (array == null || array.getArray() == null){
            try {
                throw new ArrayExistencyException("Array should be not null");
            } catch (ArrayExistencyException e) {
                e.printStackTrace();
            }
        }
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
        return super.toString();
    }
}
