package com.company;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static void fillSet(HashSet<Segment> set, int count) {
        for (int i = 0; i < count; i++) {
            set.add(Segment.generateSegment(10));
        }
    }

    private static void showSet(HashSet<Segment> set) {
        Iterator<Segment> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static Segment findMinAxis(HashSet<Segment> set) {
        double min = 10;
        Iterator<Segment> iter = set.iterator();
        Segment answer = iter.next();
        while (iter.hasNext()) {
            Segment curr = iter.next();
            if (curr.getStart().getX() < min) {
                answer = curr;
                min = curr.getStart().getX();
            }
            if (curr.getEnd().getX() < min) {
                answer = curr;
                min = curr.getEnd().getX();
            }
        }

        return (answer);
    }

    private static boolean checkCross(Dot dot, Segment s) {
        double x1 = s.getStart().getX();
        double y1 = s.getStart().getY();
        double x2 = s.getEnd().getX();
        double y2 = s.getEnd().getY();
        double x = dot.getX();
        double y = dot.getY();
        if ((x - x1) * (x - x2) <= 0 && (y - y1) * (y - y2) <= 0)
            return true;
        else
            return false;
    }

    private static Dot findCross(Segment s1, Segment s2) {
        Equation eqSeg1 = new Equation(s1);
        Equation eqSeg2 = new Equation(s2);
        double k1 = eqSeg1.getK();
        double b1 = eqSeg1.getB();
        double k2 = eqSeg2.getK();
        double b2 = eqSeg2.getB();
        double x = (b2 - b1) / (k1 - k2);
        double y = k1 * x + b1;
        Dot dot = new Dot(x, y);
        if (checkCross(dot, s1) && checkCross(dot, s2)) {
            return (dot);
        }
        else {
            return null;
        }
    }

    private static Dot inputDot() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter X: ");
        double x = in.nextDouble();
        System.out.print("Enter Y: ");
        double y = in.nextDouble();
        return new Dot(x, y);
    }

    private static Segment inputSegment() {
        System.out.println("Start:");
        Dot start = inputDot();
        System.out.println("End:");
        Dot end = inputDot();
        return new Segment(start, end);
    }

    private static void inputDots(HashSet<Segment> set) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to enter a segment (yes, no)? ");
            if (in.next().equals("no")) {
                break;
            }
            set.add(inputSegment());
        }
    }

    private static void checkCsosses(Segment s, HashSet<Segment> set) {
        Iterator<Segment> iter = set.iterator();
        while (iter.hasNext()) {
            Segment curr = iter.next();
            Dot cross = findCross(s, curr);
            System.out.print(String.format("[%s] and [%s] cross:\n\t",
                    s, curr));
            if (cross != null) {
                System.out.println("Cross: " + cross);
            }
            else {
                System.out.println("Segments haven't a cross");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashSet<Segment> set = new HashSet<>();
        inputDots(set);
        fillSet(set, 10);
        showSet(set);
        System.out.println();
        Segment min = findMinAxis(set);
        System.out.println("Min axis segment:\n" + min);
        System.out.println();
        set.remove(min);
        checkCsosses(min, set);


    }
}
