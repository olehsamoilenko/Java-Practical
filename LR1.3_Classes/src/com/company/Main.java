package com.company;

import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static void createBase(AirTour[] tours) {
        Random rand = new Random();
        for(int i = 0; i < tours.length; i++) {
            if (tours[i] == null) {
                tours[i] = AirTour.generate();
            }
        }
    }

    private static void readTours(AirTour[] tours) {
        Scanner in = new Scanner(System.in);
        Scanner inInt = new Scanner(System.in);
        Scanner inDouble = new Scanner(System.in);
        String input;
        String name;
        String operator;
        String line;
        String[] points;
        double price;
        int amount;
        int open;
        int month;
        int day;
        int counter = 0;
        while (true) {
            System.out.print("Do you want to input your own tour ('Yes' or 'No')? ");
            input = in.nextLine();
            if (input.equals("No"))
                return;
            try {
                System.out.print("Enter a name of tour: ");
                name = in.nextLine();
                System.out.print("Enter a name of tour operator: ");
                operator = in.nextLine();
                System.out.print("Enter points of tour (example: 'first second third'): ");
                line = in.nextLine();
                points = line.split(" ");
                System.out.print("Enter a price of tour: ");
                price = inDouble.nextDouble();
                System.out.print("Enter an amount of people: ");
                amount = inInt.nextInt();
                System.out.print("Enter an amount of open places: ");
                open = inInt.nextInt();
                System.out.print("Enter a month: ");
                month = inInt.nextInt();
                System.out.print("Enter a day: ");
                day = inInt.nextInt();
                GregorianCalendar date = new GregorianCalendar(2018, month, day);
                tours[counter] = new AirTour(name, operator, points, price, amount, open, date);
                counter++;
            }
            catch (InputMismatchException e) {
                System.out.println("Error");
                System.exit(1);
            }
        }
    }

    private static void toursByOperator(AirTour[] listOfTours) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the operator for searching: ");
        String operator = in.nextLine();
        boolean empty = true;
        for(AirTour tour : listOfTours) {
            if (operator.equals(tour.getOperator())) {
                System.out.println(tour.toString());
                empty = false;
            }
        }
        if (empty) {
            System.out.printf("Any tour by operator %s:(\n", operator);
        }
    }

    private static void toursByPoint(AirTour[] listOfTours) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the point for searching: ");
        String point = in.nextLine();
        boolean empty = true;
        for(AirTour tour : listOfTours) {
            boolean res = false;
            for (String town : tour.getPoints()) {
                if (point.equals(town))
                    res = true;
            }
            if (res == true) {
                System.out.println(tour.toString());
                empty = false;
            }
        }
        if (empty) {
            System.out.printf("Any tour with the point %s:(\n", point);
        }
    }

    private static void toursByDate(AirTour[] listOfTours) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the month for searching: ");
        int month = in.nextInt();
        System.out.print("Enter the day for searching: ");
        int day = in.nextInt();
        boolean empty = true;
        for(AirTour tour : listOfTours) {
            GregorianCalendar date = tour.getDate();
            int tourMonth = date.get(GregorianCalendar.MONTH);
            int tourDay = date.get(GregorianCalendar.DAY_OF_MONTH);
            if (tour.getOpen() != 0 && (tourMonth < month || tourMonth == month && tourDay < day)) {
                System.out.println(tour.toString());
                empty = false;
            }
        }
        if (empty) {
            System.out.printf("Any tour before %d.%d:(\n", day, month);
        }
    }

    public static void main(String[] args) {
        // methods return array, toString in main
        //generate methout not in tour

        AirTour[] tours = new AirTour[20];
        readTours(tours);
        createBase(tours);
        for(AirTour tour : tours) {
            System.out.println(tour);
        }
        toursByOperator(tours);
        toursByPoint(tours);
        toursByDate(tours);
    }
}
