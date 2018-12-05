package com.company;

public class Segment {

    // equals, hashcode

    private Dot start;
    private Dot end;

    public Segment(Dot start, Dot end) {
        this.start = start;
        this.end = end;
    }

    public static Segment generateSegment(double measure) {
        return new Segment(Dot.generateDot(measure), Dot.generateDot(measure));
    }

    public String toString() {
        return String.format("Start %s, End %s", start, end);
    }

    public Dot getStart() {
        return start;
    }
    public Dot getEnd() {
        return end;
    }
}
