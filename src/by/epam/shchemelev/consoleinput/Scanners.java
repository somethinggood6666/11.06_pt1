package by.epam.shchemelev.consoleinput;

import by.epam.shchemelev.exceptions.InvalidDataException;
import by.epam.shchemelev.exceptions.InvalidNumberException;

import java.util.Scanner;

public class Scanners {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputIntegerNumber(){
        String num = scanner.nextLine();
        requireNumber(num, "integer");
        return Integer.parseInt(num);
    }

    public static int inputPositiveIntegerNumber(){
        String num = scanner.nextLine();
        requireNumber(num, "positive");
        return Integer.parseInt(num);
    }

    public static String inputFilePath(){
        String num = scanner.nextLine();
        requireFilePath(num);
        return num;
    }

    private static void requireFilePath(String path) {
        if (!path.matches("^(?!.*[\\\\\\/]\\s+)(?!(?:.*\\s|.*\\.|\\W+)$)(?:[a-zA-Z]:)?(?:(?:[^<>:\"\\|\\?\\*\\n])+(?:\\/\\/|\\/|\\\\\\\\|\\\\)?)+$")){
            try {
                throw new InvalidDataException("File path has wrong format");
            } catch (InvalidDataException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public static void requireNumber(String number, String requiredNumberType){
        if ((   requiredNumberType.equalsIgnoreCase("positive") && !number.matches("\\d+")
            || (!number.matches("[-+]?\\d+")))){
            try {
                throw new InvalidNumberException("Number has wrong format");
            } catch (InvalidNumberException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

    }
}
