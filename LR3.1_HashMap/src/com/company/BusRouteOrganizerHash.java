package com.company;

/*
 *  3. Сохраните те же объекты в коллекцию HashMap, где они будут выступать ключами.
 *  Напишите методы для обработки такой коллекции:
 *  – метод для поиска значения по ключу;
 *  – метод для поиска ключей по значению;
 *  – метод, выполняющий операцию из задания 3 по варианту.
 *
 *  3. Напишите метод, который принимает в качестве параметров две коллекции Map и удаляет из
 *  первой коллекции все значения (не ключи), которые встречаются во второй коллекции.
 */


import java.util.HashMap;

public class BusRouteOrganizerHash {
    private HashMap<BusRoute, String> busRoutes;

    public BusRouteOrganizerHash() {
        busRoutes = new HashMap<>();
    }

    public String find(BusRoute route) {
        return (busRoutes.get(route));
    }

    public BusRoute find(String value) {
        for (HashMap.Entry<BusRoute, String> entry : busRoutes.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void addRoute(BusRoute route, String value) {
        busRoutes.put(route, value);
    }

    public void removeRoute(BusRoute route) {
        busRoutes.remove(route);
    }

    public void showRoutes() {
        for (BusRoute route : busRoutes.keySet()) {
            System.out.println(route);
        }
    }

    public static void removeValues(BusRouteOrganizerHash from, BusRouteOrganizerHash values) {
        for (HashMap.Entry<BusRoute, String> entry : values.busRoutes.entrySet()) {
            String valueToDel = entry.getValue();
            BusRoute keyToDel = from.find(valueToDel);
            from.removeRoute(keyToDel);
        }
    }
}
