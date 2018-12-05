package com.company;

import java.util.Random;

public class Dot {
    private double x;
    private double y;

    public Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return String.format("dot: (%6.2f; %6.2f)", x, y);
    }

    public static Dot generateDot(double measure) {
        Random rand = new Random();
        return new Dot(measure * (rand.nextDouble() - rand.nextDouble()),
                measure * (rand.nextDouble() - rand.nextDouble()));
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
