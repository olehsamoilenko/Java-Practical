package com.company;

/*
    Вариант 1
 */

public class Main {

    public static BusRoute blueBranch() {
        BusRoute route = new BusRoute();
        route.addStop("Vystavkovyi Tsentr", 0);
        route.addStop("Vasylkivska", 180);
        route.addStop("Holosiivska", 150);
        route.addStop("Demiivska", 10);
        route.addStop("Lybidska", 10);
        route.addStop("Palats \"Ukrayina\"", 10);
        route.addStop("Olimpiiska", 50);
        return route;
    }

    public static BusRoute redBranch() {
        BusRoute route = new BusRoute();
        route.addStop("Akademmistechko", 0);
        route.addStop("Zhytomyrska", 180);
        route.addStop("Sviatoshyn", 150);
        route.addStop("Nyvky", 10);
        return route;
    }

    public static BusRoute greenBranch() {
        BusRoute route = new BusRoute();
        route.addStop("Syrets", 0);
        route.addStop("Dorohozhychi", 180);
        route.addStop("Lukianivska", 150);
        route.addStop("Lvivska Brama", 10);
        route.addStop("Zoloti Vorota", 10);
        route.addStop("Palats Sportu", 10);
        return route;
    }

    public static void main(String[] args) {
        /* 1 */
        System.out.println("1. BusRoute & FastBusRoute");
        BusRoute route = blueBranch();
        System.out.println(route);
        FastBusRoute fastRoute = new FastBusRoute(route);
        System.out.println(fastRoute);

        /* 2 */
        System.out.println("2. BusRouteOrganizer & Sorting");
        BusRouteOrganizer organizer = new BusRouteOrganizer();
        organizer.addRoute(blueBranch());
        organizer.addRoute(greenBranch());
        organizer.addRoute(redBranch());
        organizer.sortRoutesMyself();
        organizer.showRoutes();

        /* 3 */
        System.out.println("3. BusRouteOrganizerHash & Removing");
        BusRoute green;
        BusRouteOrganizerHash organizer2 = new BusRouteOrganizerHash();
        organizer2.addRoute(blueBranch(), "Blue");
        organizer2.addRoute(green = greenBranch(), "Green");
        organizer2.addRoute(redBranch(), "Red");
//        organizer2.showRoutes();
//        System.out.println();
//        System.out.println(organizer2.find(green));
//        System.out.println(organizer2.find("Green"));
        BusRouteOrganizerHash toRemove = new BusRouteOrganizerHash();
        toRemove.addRoute(greenBranch(), "Green");
        toRemove.addRoute(blueBranch(), "Blue");
        BusRouteOrganizerHash.removeValues(organizer2, toRemove);
        organizer2.showRoutes();
    }
}
