package com.viv.creationaldesignpattern.objectpool;

import javafx.geometry.Point2D;

public class Bitmap implements Image {

    private Point2D location;

    private String name;

    public Bitmap(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing an " + name + " at " + location);
    }

    @Override
    public Point2D getLocation() {
        return location;

    }

    @Override
    public void setLocation(Point2D location) {
        this.location = location;
    }

    @Override
    public void reset() {
        location = null;
        System.out.println(name + " reset");
    }
    

}
