package com.company;

/*
 *  1. Выполните задание 1 по варианту, при этом для всех вариантов необходимо:
 *  – в базовом классе определить конструктор по умолчанию, конструктор с параметрами и
 *  копирующий конструктор;
 *  – в базовом классе переопределить все не финальные методы класса Object;
 *  – все методы реализовать в двух вариантах – как метод реализации и как метод класса
 *  (статический).
 *
 *  1. Создайте класс «Автобусный маршрут». Внутреннее представление маршрута – список
 *  (List) либо массив названий остановок (пунктов, по которым проходит маршрут), а также
 *  массив интервалов по времени между соседними остановками. Реализуйте методы класса
 *  (статические) и методы реализации (не статические):
 *  – для добавления новых остановок;
 *  – для вывода маршрута в строку в виде «Начальный_пункт – Пункт1 – Пункт2...
 *  Конечный_Пункт».
 */

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class BusRoute implements Comparable {
    protected LinkedList<String> busStops;
    protected LinkedList<Integer> timeIntervals; /* in seconds */

    public BusRoute() {
        busStops = new LinkedList<String>();
        timeIntervals = new LinkedList<Integer>();
    }

    public BusRoute(LinkedList<String> busStops, LinkedList<Integer> timeIntervals) {
        this.busStops = busStops;
        this.timeIntervals = timeIntervals;
    }

    public BusRoute(BusRoute route) {
        this.busStops = new LinkedList<>(route.busStops);
        this.timeIntervals = new LinkedList<>(route.timeIntervals);
    }

    public boolean addStop(String stopName, int timeInterval) { /* between previous stop and new stop */
        if (timeInterval >= 0) {
            busStops.add(stopName);
            timeIntervals.add(timeInterval);
            return (true);
        }
        else {
            return (false);
        }
    }

    public void showRoute() {
        System.out.println(this);
    }

    @Override
    public int compareTo(Object o) {
        BusRoute b = (BusRoute) o;
        if (busStops.size() == 0) {
            return -1;
        }
        else if (b.busStops.size() == 0) {
            return 1;
        }
        else {
            return this.busStops.get(0).compareTo(b.busStops.get(0));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(busStops, timeIntervals);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (!(obj instanceof BusRoute)) {
            return false;
        }
        else {
            BusRoute busRoute = (BusRoute) obj;
            return (busStops.equals(busRoute.busStops) &&
                    timeIntervals.equals(busRoute.timeIntervals));
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new BusRoute(this);
    }

    @Override
    public String toString() {
        String res = "";

        ListIterator i = busStops.listIterator();
        if (i.hasNext()) {
            res += i.next();
            while (i.hasNext()) {
                res += String.format(" - %s", i.next());
            }
        }
        else {
            res = "Route is empty.";
        }
        return res;
    }
}
