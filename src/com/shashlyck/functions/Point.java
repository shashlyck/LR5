package com.shashlyck.functions;

public class Point {

    final public double x;
    final public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String getX(){
        return x + "";
    }

    public String getY(){
        return y + "";
    }
}
