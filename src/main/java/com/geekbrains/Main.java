package com.geekbrains;

import com.geekbrains.exceptions.MyArrayDataException;
import com.geekbrains.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        String[][] test1 = {
                {"1", "1", "1", "1" },
                {"2", "2", "2", "2" },
                {"3", "3", "3", "3" },
                {"4", "4", "4", "4" }
        };

        String[][] test2 = {
                {"1", "1", "1", "1" },
                {"2", "2", "2", "2" },
                {"3", "3", "3" },
                {"4", "4", "4", "4" }
        };

        String[][] test3 = {
                {"1", "1", "1", "1" },
                {"2", "2", "2", "2" },
                {"3", "3", "3", "G" },
                {"4", "4", "4", "4" }
        };

        try {
            System.out.println(arraySum(test1));
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println(arraySum(test2));
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }

        try {
            System.out.println(arraySum(test3));
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }


    }

    private static int arraySum(String[][] array) throws MyArrayDataException, MyArraySizeException {
        int output = 0;
        if (array.length != 4) throw new MyArraySizeException("Array size should be 4X4");

        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) throw new MyArraySizeException("Array size should be 4X4");

            for (int j = 0; j < 4; j++) {
                try {
                    output += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    StringBuilder s = new StringBuilder("Некорректные данные в ячейке - {");
                    s.append(i);
                    s.append(", ");
                    s.append(j);
                    s.append("} - ");
                    s.append(array[i][j]);
                    throw new MyArrayDataException(s.toString());
                }
            }
        }

        return output;
    }
}
