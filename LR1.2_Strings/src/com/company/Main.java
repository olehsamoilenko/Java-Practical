package com.company;

import java.util.Scanner;

public class Main {

    public static String input() {
        System.out.printf("Enter the text ('eof' for end):\n");
        Scanner in = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        String nextLine;
        while ((nextLine = in.nextLine()).equals("eof") == false) {
            str.append(nextLine);
            str.append("\n");
        }
        return (str.toString());
    }

    public static String modify() {
        String text = input();
        return(modify(text));
    }

    public static String modify(String text) {
        String[] lines = text.split("\n+");
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            String[] words = line.split(" +");
            for (int j = 0; j < words.length; j++) {
                if (!words[j].equals("")) {
                    builder.append(words[j]);
                    if (j != words.length - 1) {
                        builder.append(' ');
                    }
                }
            }
            if (words.length != 0) {
                builder.append("\n");
            }
        }
        return (builder.toString());
    }

    public static void main(String[] args) {
        String text = "    Oleh      Oleh2        ";
        System.out.printf("Formatted text:\n%s", modify());
    }
}
