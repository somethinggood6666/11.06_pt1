package by.epam.shchemelev.arrayfillers;

import by.epam.shchemelev.Array;
import by.epam.shchemelev.consoleinput.Scanners;
import by.epam.shchemelev.exceptions.InvalidDataException;
import by.epam.shchemelev.exceptions.NoSuchFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayFiller {

    public static void fillArrayWithRandomNumbers(Array array){
        System.out.println("Enter array size");
        int length = Scanners.inputPositiveIntegerNumber();
        int[] arr = new int[length];
        int k = 0;
        for (int i = 0; i < length; i++) {
            arr[k] = (int)(Math.random() * 100);
        }
        array.setArray(arr);
    }

    public static void fillArrayWithConsole(Array array){
        int length = Scanners.inputPositiveIntegerNumber();
        int[] arr = new int[length];
        int k = 0;
        for (int i = 0; i < length; i++) {
            System.out.println("Enter " + (i + 1) + " element: ");
            arr[k] = Scanners.inputIntegerNumber();
        }
    }

    public static void fillArrayWithFile(Array array) throws FileNotFoundException {
        String path = Scanners.inputFilePath();
        File file = new File(path);
        requireExistingFile(file);

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

    private static void requireExistingFile(File file) {
        if (!file.exists()){
            try {
                throw new NoSuchFileException("File " + file.getName() + " doesnt exists");
            } catch (NoSuchFileException e) {
                e.printStackTrace();
            }
        }
    }

}
