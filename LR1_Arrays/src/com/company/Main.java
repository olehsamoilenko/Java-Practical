package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static double[][] create(int n) {
        double[][] array = new double[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Math.random() * rand.nextInt(15) * (1 - 2 * rand.nextInt(2));
            }
        }
        return (array);
    }

    static void print (double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%10.1f ", array[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    static void round (double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Math.round(array[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.printf("Samoilenko O. A.\n");
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter the size: ");
        int n;
        while ((n = in.nextInt()) <= 0) {
            System.out.printf("Error. Try again: ");
        }
        double[][] array = create(n);
        print(array);
        round(array);
        print(array);
    }
}
