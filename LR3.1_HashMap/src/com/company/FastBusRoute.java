package com.company;

/*
 *  Создайте производный класс, в котором:
 *  – добавьте метод для нахождения времени проезда между любыми двумя заданными
 * остановками;
 *  – переопределите метод toString() для вывода маршрута в виде «Маршрут от
 *  Начальный_пункт до Конечный_пункт занимает X минут».
 */

public class FastBusRoute extends BusRoute {

    public FastBusRoute() {
        super();
    }

    public FastBusRoute(BusRoute route) {
        super(route);
    }

    public int duration(String start, String end) { /* in seconds */
        if (busStops.contains(start) && busStops.contains(end) &&
                busStops.indexOf(start) < busStops.indexOf(end)) {
            int duration = 0;
            for (int i = busStops.indexOf(start) + 1; i <= busStops.indexOf(end); i++) {
                duration += timeIntervals.get(i);
            }
            return (duration);
        }
        else {
            return (-1);
        }
    }

    @Override
    public String toString() {
        if (busStops.size() != 0) {
            return String.format("Маршрут от %s до %s занимает %d минут",
                    busStops.get(0), busStops.get(busStops.size() - 1),
                    duration(busStops.get(0), busStops.get(busStops.size() - 1)) / 60);
        }
        else {
            return "Маршрут пуст";
        }
    }
}
