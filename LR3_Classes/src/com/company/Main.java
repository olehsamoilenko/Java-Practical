package com.company;

import java.util.*;

public class Main {

    static void showList(ArrayList<AirTour> list) {
        int counter = 1;
        for(AirTour tour : list) {
            System.out.printf("%d %s\n", counter++, tour.getName());
        }
        if (list.size() == 0)
            System.out.println("The list is clear");
        System.out.println();
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

    static String generateName(int number) {
        Random rand = new Random();
        String name = "Tour" + number;
        int type = rand.nextInt(3);
        if (type == 1)
            name = "Good" + name;
        if (type == 2)
            name = "Awesome" + name;
        return (name);
    }

    static String generateOperator() {
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

    static GregorianCalendar generateDate() {
        Random rand = new Random();
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.DAY_OF_YEAR, rand.nextInt(60));
        return (calendar);
    }

    static ArrayList<AirTour> createBase(int size) {
        ArrayList<AirTour> tours = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < size; i++) {
            tours.add(new AirTour(generateName(i), generateOperator(), generatePoints(),
                    rand.nextDouble() * 1000, rand.nextInt(50) + 1,
                    rand.nextInt(3), generateDate()));
        }
        return (tours);
    }

    static void readTours(ArrayList<AirTour> tours) {
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
                tours.add(new AirTour(name, operator, points, price, amount, open, date));
            }
            catch (InputMismatchException e) {
                System.out.println("Error");
                System.exit(1);
            }
        }
    }

    static ArrayList<AirTour> toursByOperator(ArrayList<AirTour> listOfTours) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the operator for searching: ");
        String operator = in.nextLine();
        ArrayList<AirTour> toursByOperator = new ArrayList<>();
        for(AirTour tour : listOfTours) {
            if (operator.equals(tour.getOperator()))
                toursByOperator.add(tour);
        }
        return (toursByOperator);
    }

    static ArrayList<AirTour> toursByPoint(ArrayList<AirTour> listOfTours) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the point for searching: ");
        String point = in.nextLine();
        ArrayList<AirTour> toursByPoint = new ArrayList<>();
        for(AirTour tour : listOfTours) {
            boolean res = false;
            for (String town : tour.getPoints()) {
                if (point.equals(town))
                    res = true;
            }
            if (res == true)
                toursByPoint.add(tour);
        }
        return (toursByPoint);
    }

    static ArrayList<AirTour> toursByDate(ArrayList<AirTour> listOfTours) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the month for searching: ");
        int month = in.nextInt();
        System.out.print("Enter the day for searching: ");
        int day = in.nextInt();
        ArrayList<AirTour> toursByDate = new ArrayList<>();
        for(AirTour tour : listOfTours) {
            GregorianCalendar date = tour.getDate();
            int tourMonth = date.get(GregorianCalendar.MONTH);
            int tourDay = date.get(GregorianCalendar.DAY_OF_MONTH);
            if (tour.getOpen() != 0 && (tourMonth < month || tourMonth == month && tourDay < day))
                toursByDate.add(tour);
        }
        return (toursByDate);
    }

    public static void main(String[] args) {
        // LIST -> ARRAY
        // showInfo -> toString
        // error exceptions
        // private static methods
        ArrayList<AirTour> tours = createBase(10);
        readTours(tours);
        for(AirTour tour : tours) {
            tour.showInfo();
        }
        ArrayList<AirTour> tours1 = toursByOperator(tours);
        showList(tours1);
        ArrayList<AirTour> tours2 = toursByPoint(tours);
        showList(tours2);
        ArrayList<AirTour> tours3 = toursByDate(tours);
        showList(tours3);
    }
}
