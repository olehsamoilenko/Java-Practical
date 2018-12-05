package com.company;

public class Equation {
    private double k;
    private double b;

//    public Equation(double k, double b) {
//        this.k = k;
//        this.b = b;
//    }
    public Equation(Segment s) {
        // segment 1 equation: y = kx + b
        double x1 = s.getStart().getX();
        double y1 = s.getStart().getY();
        double x2 = s.getEnd().getX();
        double y2 = s.getEnd().getY();
        double k = (y2 - y1) / (x2 - x1);
        double b = y2 - (y2 - y1) / (x2 - x1) * x2;
        this.k = k;
        this.b = b;
//        System.out.println("K " + k);
//        System.out.println("B " + b);
    }

    public double getK() {
        return k;
    }
    public double getB() {
        return b;
    }
}
