package com.company;

import java.awt.*;
import java.util.Scanner;

public class Main {

    private static void prepare(Container bosses, Container districts, Container inspectors, Container residents) {
        Boss b = new Boss("Олег", "Самойленко");
        bosses.add(b);
        District gol = new District("Голосеевский");
        districts.add(gol);
        districts.add(new District("Демеевский"));
        b.approveDistrict(gol);
        Inspector ins = new Inspector("Андрей", "Андреев");
        inspectors.add(ins);
        inspectors.add(new Inspector("Иван", "Иванов"));
        b.distributeDistrict(gol, ins);
        Resident res = new Resident("Екатерина", "Екатеринова");
        Resident res2 = new Resident("Мария", "Шевченко");
        residents.add(res);
        residents.add(res2);
        ins.createRegistration(res2, "Ломоносова, 47");
        res.makeApplication(ins, "Я хочу продлить свою прописку!");
    }

    public static void main(String[] args) {

        Container bosses = new Container("bosses");
        Container districts = new Container("districts");
        Container inspectors = new Container("inspectors");
        Container residents = new Container("residents");

        prepare(bosses, districts, inspectors, residents);

        Scanner sc = new Scanner(System.in);
        String answer;
        while (true) {
            System.out.print("1 - Create an user\n2 - Create a district\n3 - Enter the system\n4 - Exit\nEnter your answer: ");
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    createUser(bosses, inspectors, residents);
                    break;
                case "2":
                    createDistrict(districts);
                    break;
                case "3":
                    enter(bosses, inspectors, residents, districts);
                    break;
                case "4":
                    return;
                default:
                    bosses.show();
                    districts.show();
                    inspectors.show();
                    residents.show();
                    break;
            }
        }
    }

    private static void createUser(Container bosses, Container inspectors, Container residents) {
        Scanner sc = new Scanner(System.in);
        start:
        while (true) {
            System.out.print("1 - Create a boss\n2 - Create an inspector\n3 - Create a resident\n4 - Back\nEnter your answer: ");
            String answer = sc.nextLine();
            String name = null;
            String surname = null;
            if (answer.equals("1") || answer.equals("2") || answer.equals("3")) {
                System.out.print("Enter name: ");
                name = sc.nextLine();
                System.out.print("Enter surname: ");
                surname = sc.nextLine();
            }
            switch (answer) {
                case "1":
                    bosses.add(new Boss(name, surname));
                    break;
                case "2":
                    inspectors.add(new Inspector(name, surname));
                    break;
                case "3":
                    residents.add(new Resident(name, surname));
                    break;
                case "4":
                    break start;
                default:
                    break;
            }
        }
    }

    private static void createDistrict(Container districts) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter district name: ");
        String name = sc.nextLine();
        districts.add(new District(name));
    }

    private static void enter(Container bosses, Container inspectors, Container residents, Container districts) {
        Scanner sc = new Scanner(System.in);
        String answer;
        start:
        while (true) {
            System.out.print("1 - Boss\n2 - Inspector\n3 - Resident\n4 - Back\nEnter like: ");
            answer = sc.nextLine();
            int num;
            Man user;

            switch (answer) {
                case "1":
                    bosses.show();
                    System.out.print("Enter like: ");
                    num = Integer.parseInt(sc.nextLine());
                    user = (Boss) bosses.get(num);
                    bossActions((Boss) user, districts, inspectors);
                    break;
                case "2":
                    inspectors.show();
                    System.out.print("Enter like: ");
                    num = Integer.parseInt(sc.nextLine());
                    user = (Inspector) inspectors.get(num);
                    inspectorActions((Inspector) user, residents);
                    break;
                case "3":
                    residents.show();
                    System.out.print("Enter like: ");
                    num = Integer.parseInt(sc.nextLine());
                    user = (Resident) residents.get(num);
                    System.out.println(user);
                    residentActions((Resident)user);
                    break;
                case "4":
                    break start;
                default:
                    break;
            }
        }
    }

    private static void bossActions(Boss user, Container districts, Container inspectors) {
        Scanner sc = new Scanner(System.in);
        String answer;
        while (true) {
            System.out.print("1 - Approve a district\n2 - Distribute a district\n3 - Back\nEnter your answer: ");
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    districts.show();
                    System.out.print("Select district to approve: ");
                    int num = Integer.parseInt(sc.nextLine());
                    user.approveDistrict((District) districts.get(num));
                    break;
                case "2":
                    districts.show();
                    System.out.print("Select district to distribute: ");
                    int dist_num = Integer.parseInt(sc.nextLine());
                    inspectors.show();
                    System.out.print("Select inspector to distribute: ");
                    int ins_num = Integer.parseInt(sc.nextLine());
                    user.distributeDistrict((District) districts.get(dist_num), (Inspector) inspectors.get(ins_num));
                    break;
                case "3":
                    return;
                default:
                    break;
            }
        }
    }

    private static void inspectorActions(Inspector user, Container residents) {
        Scanner sc = new Scanner(System.in);
        String answer;
        while (true) {
            System.out.print("1 - Create a registration\n2 - Remove registration\n3 - Make an application\n4 - Show applications\n5 - Back\nEnter your answer: ");
            answer = sc.nextLine();
            int num;
            switch (answer) {
                case "1":
                    residents.show();
                    System.out.print("Select resident to registrate: ");
                    num = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();
                    user.createRegistration((Resident) residents.get(num), address);
                    break;
                case "2":
                    user.getDistrict().getResidents().show();
                    System.out.print("Select resident to remove registration: ");
                    num = Integer.parseInt(sc.nextLine());
                    user.removeRegistration((Resident) residents.get(num));
                    break;
                case "3":
                    user.getDistrict().getResidents().show();
                    System.out.print("Select resident to apply: ");
                    num = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter message: ");
                    String message = sc.nextLine();
                    user.makeApplication((Man) user.getDistrict().getResidents().get(num), message);
                    break;
                case "4":
                    user.showApplications();
                    break;
                case "5":
                    return;
                default:
                    break;
            }
        }
    }

    private static void residentActions(Resident user) {
        Scanner sc = new Scanner(System.in);
        String answer;
        while (true) {
            System.out.print("1 - Make an application\n2 - Show applications\n3 - Back\nEnter your answer: ");
            answer = sc.nextLine();
            switch (answer) {
                case "1":
                    System.out.print("Enter message: ");
                    String message = sc.nextLine();
                    user.makeApplication(user.getDistrict().getInspector(), message);
                    break;
                case "2":
                    user.showApplications();
                    break;
                case "3":
                    return;
                default:
                    break;
            }
        }

    }
}
