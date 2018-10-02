package com.company;

import java.util.GregorianCalendar;

public class AirTour {
    public String name;
    private String operator;
    private String[] points;
    private double price;
    private int amount;
    private int open;
    private GregorianCalendar date;

    public AirTour() {

    }

    public AirTour(String name, String operator, String[] points, double price, int amount, int open, GregorianCalendar date) {
        this.name = name;
        this.operator = operator;
        this.points = points;
        this.price = price;
        this.amount = amount;
        this.open = open;
        this.date = date;
    }

    public String getOperator() {
        return (operator);
    }

    public String getTour() {
        return (name);
    }

    public String[] getPoints() {
        return (points);
    }

    public GregorianCalendar getDate() {
        return (date);
    }

    public int getOpen() {
        return (open);
    }

    public void ShowInfo() {
        System.out.printf("Name: %s\n", name);
        System.out.printf("Tour operator: %s\n", operator);
        String listOfPoints = "";
        for(int i = 0; i < points.length; i++) {
            listOfPoints += points[i];
            if (i != points.length - 1)
                listOfPoints += ", ";
        }
        System.out.printf("Points: %s\n", listOfPoints);
        System.out.printf("Price: %.2f$\n", price);
        System.out.printf("Amount of people: %d\n", amount);
        System.out.printf("Open sits: %d\n", open);
        System.out.printf("Date of start: %s\n", date.getTime());
        System.out.println();
    }
}
