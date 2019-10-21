package com.company;

/*
 *  2. Объедините несколько созданных объектов своего класса (из задания 1 по варианту) в
 *  список List. Реализуйте добавление, удаление объектов в списке, а также вывод списка на
 *  экран. Для полученного списка выполните задание 2 по варианту двумя способами:
 *  а) с помощью методов класса Collections;
 *  б) без использования методов класса Collections
 *  (т. е. реализовав алгоритм самостоятельно).
 *
 *  2. Напишите метод для сортировки списка маршрутов по названию начального пункта, а затем
 *  по названию конечного пункта.
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BusRouteOrganizer {
    private LinkedList<Comparable> busRoutes;

    public BusRouteOrganizer() {
        busRoutes = new LinkedList<>();
    }

    public void addRoute(BusRoute route) {
        busRoutes.add(route);
    }

    public void removeRoute(int index) {
        busRoutes.remove(index);
    }

    public void showRoutes() {
        ListIterator i = busRoutes.listIterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public void sortRoutes() {
        Collections.sort(busRoutes);
    }

    public void sortRoutes(Comparator cmp) {
        Collections.sort(busRoutes, cmp);
    }

    public void sortRoutesMyself() {
        sortRoutesMyself(busRoutes);
    }

    public void sortRoutesMyself(Comparator cmp) {
        sortRoutesMyself(busRoutes, cmp);
    }

    private static void sortRoutesMyself(LinkedList<Comparable> lst) {
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.size(); j++) {
                if (lst.get(i).compareTo(lst.get(j)) < 0) {
                    Comparable tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }

    private static void sortRoutesMyself(LinkedList<Comparable> lst, Comparator cmp) {
        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.size(); j++) {
                if (cmp.compare(lst.get(i), lst.get(j)) < 0) {
                    Comparable tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}
