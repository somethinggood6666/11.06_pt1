package by.epam.shchemelev;

import by.epam.shchemelev.array.Array;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(1,2,3,4,5,5,5,2);

        Array.addElement(array, 10);
        Array.removeElement(array, 5);
        Array.removeElementByIndex(array, 2);

        System.out.println("fdsaf");
    }
}
