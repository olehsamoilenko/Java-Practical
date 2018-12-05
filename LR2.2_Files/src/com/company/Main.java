package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    private static String[] readFile(String name) {
        int i;
        StringBuilder str = new StringBuilder();
        try {
            FileInputStream fin = new FileInputStream(name);
            while ((i = fin.read()) != -1) {
                str.append((char)i);
            }
            return (str.toString().split("\n"));
        }
        catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
            System.exit(0);
            return (null);
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            System.exit(0);
            return (null);
        }

    }

    private static int getSize(String line) {
        try {
            return (Integer.parseInt(line.trim()));
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Matrix size must contain only digits");
            System.exit(0);
            return (0);
        }
    }

    private static int[][] readMatrix(int size, String[] file) {
        int[][] matrix = new int[size][size];
        try {
            if (file.length - 1 != size) {
                throw new MatrixException(String.format("Matrix must contain %d lines", size));
            }
            for (int i = 1; i <= size; i++) {
                String[] elems = file[i].trim().split(" +");
                if (elems.length != size) {
                    throw new MatrixException(String.format("Every line must contain %d elements in format '1 2 3 ...'", size));
                }
                for (int j = 0; j < size; j++) {
                    matrix[i - 1][j] = Integer.parseInt(elems[j]);
                }
            }
        }
        catch (MatrixException e) {
            System.out.println("MatrixException: " + e.getMessage());
            System.exit(0);
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Matrix must contain only digits");
            System.exit(0);
        }
        return (matrix);
    }

    private static void transponeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (i + j < matrix.length) {
                    int buf = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = buf;
                }
            }
        }
    }

    private static void numberToFile(int nbr, FileOutputStream fout) {
        try {
            String str = Integer.toString(nbr);
            for (int i = 0; i < str.length(); i++) {
                fout.write(str.charAt(i));
            }
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            System.exit(0);
        }

    }

    private static void writeToFile(int[][] matrix, String name) {
        try {
            FileOutputStream fout = new FileOutputStream(name);
            numberToFile(matrix.length, fout);
            fout.write((int)'\r');
            fout.write((int)'\n');
            for (int[] line : matrix) {
                for (int elem : line) {
                    numberToFile(elem, fout);
                    fout.write(' ');
                }
                fout.write((int)'\r');
                fout.write((int)'\n');
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        String[] file = readFile("matrix.txt");
        int size = getSize(file[0]);
        int[][] matrix = readMatrix(size, file);
        transponeMatrix(matrix);
        writeToFile(matrix, "transponed.txt");
        System.out.println("Success. Transponed matrix is written to file");
    }
}
