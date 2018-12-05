import org.apache.log4j.Logger;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    final static Logger logger = Logger.getRootLogger();

    private static void createBase(AirTour[] tours) {
        for (int i = 0; i < tours.length; i++) {
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
                if (name.equals("")) {
                    throw new EmptyStringException("Tour name cannot be an empty string");
                }
                System.out.print("Enter a name of tour operator: ");
                operator = in.nextLine();
                if (operator.equals("")) {
                    throw new EmptyStringException("Tour operator cannot be an empty string");
                }
                System.out.print("Enter points of tour (example: 'first second third'): ");
                line = in.nextLine();
                if (line.equals("")) {
                    throw new EmptyStringException("List of tours must contain at least 1 point");
                }
                points = line.split(" ");
                System.out.print("Enter a price of tour: ");
                price = inDouble.nextDouble();
                System.out.print("Enter an amount of people: ");
                amount = inInt.nextInt();
                System.out.print("Enter an amount of open places: ");
                open = inInt.nextInt();
                System.out.print("Enter a month: ");
                month = inInt.nextInt();
                if (month < 1 || month > 12) {
                    throw new CalendarException("Wrong month");
                }
                System.out.print("Enter a day: ");
                day = inInt.nextInt();
                if (day < 0 || day > 31) {
                    throw new CalendarException("Wrong day");
                }
                GregorianCalendar date = new GregorianCalendar(2018, month, day);
                tours[counter] = new AirTour(name, operator, points, price, amount, open, date);
                counter++;
            }
            catch (CalendarException e) {
                logger.error("CalendarException: " + e.getMessage());
//                System.out.println("CalendarException: " + e.getMessage());
            } catch (EmptyStringException e) {
                logger.error("EmptyStringException: " + e.getMessage());
//                System.out.println("EmptyStringException: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        AirTour[] tours = new AirTour[20];
        logger.info("App is on");
        readTours(tours);
        createBase(tours);
        for (AirTour tour : tours) {
            System.out.println(tour);
        }
        logger.info("App is off");
    }
}

