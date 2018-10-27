package com.company;

import java.util.GregorianCalendar;
import java.util.Random;

public class AirTour {
    private String name;
    private String operator;
    private String[] points;
    private double price;
    private int amount;
    private int open;
    private GregorianCalendar date;
    static int num = 0;

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

    public String getName() {
        return (name);
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

    public String toString() {
        String listOfPoints = "";
        for(int i = 0; i < points.length; i++) {
            listOfPoints += points[i];
            if (i != points.length - 1)
                listOfPoints += ", ";
        }
        String result = String.format("%-15s| %-25s| %-60s|%7.2f$|%2d/%-3d| %02d.%02d.%d",
                name, operator, listOfPoints, price, open, amount,
                date.get(GregorianCalendar.DAY_OF_MONTH), date.get(GregorianCalendar.MONTH),
                date.get(GregorianCalendar.YEAR));
        return(result);
    }

    static String[] generatePoints() {
        String[] pointsForVisiting =
                {
                        "Albi",
                        "Auch",
                        "Cahors",
                        "Castres",
                        "Foix",
                        "Gavarnie",
                        "Lourdes",
                        "Millau",
                        "Montauban",
                        "Rocamadour",
                        "Rodez",
                        "Saint-Affrique",
                        "Tarbes",
                        "Toulouse",
                        "Antequera",
                        "Coín",
                        "Málaga",
                        "Melilla",
                        "Ronda"
                };
        Random rand = new Random();
        String[] list = new String[rand.nextInt(5) + 1];
        for(int i = 0; i < list.length; i++) {
            list[i] = pointsForVisiting[rand.nextInt(pointsForVisiting.length)];
        }
        return (list);
    }

    private static String generateName() {

        Random rand = new Random();
        String name = "Tour" + num++;
        int type = rand.nextInt(3);
        if (type == 1)
            name = "Good" + name;
        if (type == 2)
            name = "Awesome" + name;
        return (name);
    }

    private static String generateOperator() {
        String[] operators =
                {
                        "Oasis Travel Ukraine",
                        "Green Tour Ukraine LLC",
                        "Ukraine Your Way",
                        "Four Travel Ukraine TOV"
                };
        Random rand = new Random();
        return (operators[rand.nextInt(operators.length)]);
    }

    private static GregorianCalendar generateDate() {
        Random rand = new Random();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.DAY_OF_YEAR, rand.nextInt(60));
        return (calendar);
    }

    public static AirTour generate() {
        Random rand = new Random();
        return (new AirTour(generateName(), generateOperator(), generatePoints(),
                rand.nextDouble() * 1000, rand.nextInt(50) + 1,
                rand.nextInt(3), generateDate()));
    }
}
